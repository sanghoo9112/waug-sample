package com.example.demo.sample.filter;

import java.math.BigDecimal;
import com.waug.cube.v1.goods.enums.Currency;
import com.waug.cube.v1.goods.option.enums.SaleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GoodsFilterCondition {

    protected BigDecimal minPrice;
    protected BigDecimal maxPrice;
    protected SaleType saleType;
    protected Currency targetCurrency;

}
