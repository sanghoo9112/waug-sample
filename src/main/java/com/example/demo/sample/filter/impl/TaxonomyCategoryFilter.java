package com.example.demo.sample.filter.impl;

import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.sample.filter.AreaGoodsFilterCondition;
import com.example.demo.sample.filter.ICriteria;
import com.example.demo.sample.good.GoodsBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


/**
 * AreaGoodsFilterCondition TaxonomyCategoryFilter
 * <p>
 * 카테고리 필터
 */
@Service
@RequiredArgsConstructor
public class TaxonomyCategoryFilter implements ICriteria<AreaGoodsFilterCondition> {

    private final GoodsTaxonomyScheduler goodsTaxonomyScheduler;


    @Override
    public boolean isContainCriteria(AreaGoodsFilterCondition areaGoodsFilterCondition) {

        return areaGoodsFilterCondition.getCategories() != null && !areaGoodsFilterCondition
                .getCategories().isEmpty();

    }


    @Override
    public List<GoodsBase> getFilteredGoods(List<GoodsBase> goodsBases,
            AreaGoodsFilterCondition areaGoodsFilterCondition) {

        return goodsBases.stream().filter(goodsBase -> hasTaxonomy(goodsBase,
                areaGoodsFilterCondition.getCategories())).collect(Collectors.toList());

    }


    /**
     * 레이지 로드로 인한 성능 이슈로 인메모리 캐시를 이용하도록 변경
     *
     * @param goodsBase
     * @param taxonomyIds
     * @return
     */
    private boolean hasTaxonomy(GoodsBase goodsBase, List<Long> taxonomyIds) {

        if(goodsTaxonomyScheduler.getGoodsTaxonomyIdMap() == null) {
            return true;
        }

        List<Long> goodsTaxonomyIds = goodsTaxonomyScheduler.getGoodsTaxonomyIdMap()
                .get(goodsBase.getGoodsId().toString());

        return CollectionUtils.isEmpty(goodsTaxonomyIds) && goodsTaxonomyIds.stream()
                .anyMatch(taxonomyIds::contains);
    }
}
