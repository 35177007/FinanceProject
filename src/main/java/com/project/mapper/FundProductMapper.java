package com.project.mapper;

import com.project.pojo.FundProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FundProductMapper {

    public List<FundProduct> selectFundProductAll();

    public int addFundProduct(FundProduct fundProduct);

    public FundProduct selectFundProductById(Integer id);

    public int updateFundProduct(FundProduct fundProduct);

    public int deleteFundProduct(Integer id);
}
