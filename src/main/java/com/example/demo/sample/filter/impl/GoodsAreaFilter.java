package com.example.demo.sample.filter.impl;

import java.util.List;
import com.example.demo.sample.config.GoodsFilterConfig;
import com.example.demo.sample.filter.GoodsFilter;
import com.example.demo.sample.filter.GoodsFilterCondition;
import com.example.demo.sample.filter.ICriteria;
import com.example.demo.sample.good.GoodsBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoodsAreaFilter implements GoodsFilter {

    private final GoodsFilterConfig goodsFilterConfig;


    @Override
    public List<GoodsBase> getFilterGoods(List<GoodsBase> goodsBases,
            GoodsFilterCondition filterCondition) {

        List<ICriteria> filters = goodsFilterConfig.getAreaGoodsFilter();

        for(ICriteria criteria : filters) {

            if(criteria.isContainCriteria(filterCondition)) {
                goodsBases = criteria.getFilteredGoods(goodsBases, filterCondition);
            }
        }
        return goodsBases;
    }
}
