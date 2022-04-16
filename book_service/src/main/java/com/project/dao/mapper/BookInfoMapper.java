package com.project.dao.mapper;

import com.project.dao.pojo.BookInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookInfoMapper {
    BookInfo findBookById(Long id);
}
