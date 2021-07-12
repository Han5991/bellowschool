package com.bellowschool.common.page;

import com.bellowschool.vo.PageRequestVo;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultVo<VO, EN> {

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

    public PageResultVo(PageRequestVo pageRequestVo) {
        makePageList(pageRequestVo);
    }

    private void makePageList(PageRequestVo pageRequestVo) {
        this.page = pageRequestVo.getPage(); // 0부터 시작하므로 1을 추가
        this.size = pageRequestVo.getSize();
        int tempTotalCount = pageRequestVo.getTotalcount();
        if (pageRequestVo.getTotalcount() / this.size == 0) {
            this.totalPage = tempTotalCount / this.size;
        } else {
            this.totalPage = tempTotalCount / this.size + 1;
        }

        //temp end page
        int tempEnd = (int) (Math.ceil(page / 10.0)) * 10;
        start = tempEnd - 9;
        prev = start > 1;
        end = totalPage > tempEnd ? tempEnd : totalPage;
        next = totalPage > tempEnd;
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

    }

}
