package com.project.mapper;

import com.project.pojo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NewsMapper{
    public List<News> selectNewsAll();
}
