package com.example.demo.sample.filter;

import java.util.List;
import com.example.demo.sample.good.GoodsBase;
import com.waug.cube.v1.goods.base.model.GoodsBase;

public interface GoodsFilter {

    List<GoodsBase> getFilterGoods(List<GoodsBase> goodsBases, GoodsFilterCondition filterCondition);

}
