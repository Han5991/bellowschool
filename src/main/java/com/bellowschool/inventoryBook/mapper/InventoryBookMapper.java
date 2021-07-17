package com.bellowschool.inventoryBook.mapper;

import com.bellowschool.vo.InventoryBookVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface InventoryBookMapper {

    List<InventoryBookVo> inventoryList();

    List<InventoryBookVo> inventoryBookList();

    int regInventoryBook(Map<String, Object> params);

    int deleteInventoryBook(Map<String, Object> params);

    int updateInventoryBook(Map<String, Object> params);

}
