package com.example.demo.sample.api;

import com.example.demo.sample.good.AgentGoodBase;
import com.example.demo.sample.good.GoodsBase;

/**
 * agent 상품 연동 manger
 */
public interface GoodsAgentManager<T> {

    T save(T t) throws AgentServerException;

    T update(T t) throws AgentServerException;

    T convert(GoodsBase goodsBase);

    <V> T convert(GoodsBase goodsBase, V additionalInfo)
            throws AgentServerException;

    AgentGoodBase convert(T t);

}
