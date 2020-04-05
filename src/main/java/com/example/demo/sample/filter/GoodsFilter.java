package com.example.demo.sample.filter;

import java.util.List;
import com.example.demo.sample.good.GoodsBase;

public interface GoodsFilter {

    List<GoodsBase> getFilterGoods(List<GoodsBase> goodsBases, GoodsFilterCondition filterCondition);

}
