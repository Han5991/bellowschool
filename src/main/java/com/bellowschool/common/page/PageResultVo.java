package com.bellowschool.common.page;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.*;

@Data
public class PageResultVo<VO> {

    //DTO리스트
    private List<VO> dtoList;

    //총 페이지 번호
    private int totalPage;

    //현재 페이지 번호
    private int page;
    //목록 사이즈
    private int size;

    //시작 페이지 번호, 끝 페이지 번호
    private int start, end;

    //이전, 다음
    private boolean prev, next;

    //페이지 번호  목록
    private List<Integer> pageList;

    public PageResultVo(PageRequestVo pageRequestVo, List<VO> result, int totalCount) {
        makePageList(pageRequestVo, result, totalCount);
    }

    private void makePageList(PageRequestVo pageRequestVo, List<VO> dtoList, int totalCount) {
        this.dtoList = dtoList;
        this.page = pageRequestVo.getPage();
        this.size = pageRequestVo.getSize();
        this.totalPage = ((totalCount / this.size) == 0) ? (totalCount / this.size) : ((totalCount / this.size) + 1);

        //temp end page
        int tempEnd = (int) (ceil(page / 10.0)) * 10;
        start = tempEnd - 9;
        prev = start > 1;
        end = min(totalPage, tempEnd);
        next = totalPage > tempEnd;
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
