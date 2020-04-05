package com.example.demo.sample.filter;

import java.util.List;
import com.example.demo.sample.good.GoodsBase;

public interface ICriteria<T extends GoodsFilterCondition> {

    boolean isContainCriteria(T t);

    List<GoodsBase> getFilteredGoods(List<GoodsBase> goodsBases, T t);
}
