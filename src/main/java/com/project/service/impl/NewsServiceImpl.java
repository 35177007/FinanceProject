package com.project.service.impl;

import com.project.mapper.NewsMapper;
import com.project.pojo.News;
import com.project.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> selectNewsAll() {
        return newsMapper.selectNewsAll();
    }
}
