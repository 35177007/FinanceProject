package com.project.service;

import com.project.pojo.FundProduct;

import java.util.List;

public interface FundProductService {
    public List<FundProduct> selectFundProductAll();

    public int addFundProduct(FundProduct fundProduct);

    public FundProduct selectFundProductById(Integer id);

    public int updateFundProduct(FundProduct fundProduct);

    public int deleteFundProduct(Integer id);
}
