package com.example.demo.sample.config;


import java.util.ArrayList;
import java.util.List;
import com.example.demo.sample.filter.ICriteria;
import com.example.demo.sample.filter.impl.TaxonomyCategoryFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;


/**
 * Goods Filter Config
 * <p>
 * 지역페이지 필터 getAreaGoodsFilter
 * 스페셜페이지 필터 getGoodsFilter
 */
@Configuration
@AllArgsConstructor
public class GoodsFilterConfig {

    private final TaxonomyCategoryFilter taxonomyCategoryFilter;


    public List<ICriteria> getAreaGoodsFilter() {

        List<ICriteria> criteriaList = new ArrayList<>();
        criteriaList.add(taxonomyCategoryFilter);
        return criteriaList;
    }


    public List<ICriteria> getGoodsFilter() {

        List<ICriteria> criteriaList = new ArrayList<>();
        return criteriaList;
    }
}
