package com.project.service.impl;

import com.project.mapper.FundProductMapper;
import com.project.pojo.FundProduct;
import com.project.service.FundProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FundProductServiceImpl implements FundProductService {
    @Autowired
    private FundProductMapper fundProductMapper;

    @Override
    public List<FundProduct> selectFundProductAll() {
        return fundProductMapper.selectFundProductAll();
    }

    @Override
    public int addFundProduct(FundProduct fundProduct) {
        return fundProductMapper.addFundProduct(fundProduct);
    }

    @Override
    public FundProduct selectFundProductById(Integer id) {
        return fundProductMapper.selectFundProductById(id);
    }

    @Override
    public int updateFundProduct(FundProduct fundProduct) {
        return fundProductMapper.updateFundProduct(fundProduct);
    }

    @Override
    public int deleteFundProduct(Integer id) {
        return fundProductMapper.deleteFundProduct(id);
    }
}
