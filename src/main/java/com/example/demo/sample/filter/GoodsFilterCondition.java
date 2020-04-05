package com.example.demo.sample.filter;

import java.math.BigDecimal;
import java.util.Currency;
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
