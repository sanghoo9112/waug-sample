package com.example.demo.sample.api;

import com.example.demo.sample.good.AgentGoodBase;
import com.example.demo.sample.good.GoodsBase;

/**
 * 템플릿 메소드 패턴
 * 연동 서비스는 다음을 구현하면 된다.
 *
 * 다만, 어드민에서 추가 정보를 입력받아야 하는 경우는
 * Object type 의 파라미터를 추가로 받아야 된다.
 *
 * @param <T> : 상품연동 모델 타입
 */
public abstract class AgentGoodsService<T> {


    final T register(GoodsBase goodsBase, AgentType agentType) throws AgentGoodSaveException {

        GoodsAgentManager<T> goodsAgentManager = getGoodAgentManager();

        AgentGoodRepository agentGoodRepository = getAgentGoodRepository();

        T t = goodsAgentManager.convert(goodsBase);

        return registerAndSave(t, agentType, goodsAgentManager, agentGoodRepository);

    }


    final <V> T register(GoodsBase goodsBase, AgentType agentType, V v)
            throws AgentGoodSaveException, AgentServerException {

        GoodsAgentManager<T> goodsAgentManager = getGoodAgentManager();

        AgentGoodRepository agentGoodRepository = getAgentGoodRepository();

        T t = goodsAgentManager.convert(goodsBase, v);

        return registerAndSave(t, agentType, goodsAgentManager, agentGoodRepository);

    }


    final T modify(GoodsBase goodsBase, AgentType agentType) {

        GoodsAgentManager<T> goodsAgentManager = getGoodAgentManager();

        T t = goodsAgentManager.convert(goodsBase);

        try {
            t = goodsAgentManager.update(t);
        } catch(AgentServerException e) {
            AgentLogManager agentLogManager = getAgentLogManager();
            saveErrorLog(agentLogManager, agentType, e.getMessage());
        }

        return t;

    }


    private T registerAndSave(T t, AgentType agentType, GoodsAgentManager<T> goodsAgentManager,
            AgentGoodRepository agentGoodRepository) throws AgentGoodSaveException {


        try {

            t = goodsAgentManager.save(t);
            AgentGoodBase agentGoodBase = goodsAgentManager.convert(t);
            agentGoodRepository.save(agentGoodBase);
            return t;

        } catch(AgentServerException e) {

            AgentLogManager agentLogManager = getAgentLogManager();
            saveErrorLog(agentLogManager, agentType, e.getMessage());
            throw new AgentGoodSaveException("agent api 상품정보 저장 실패");

        }


    }


    public abstract GoodsAgentManager<T> getGoodAgentManager();

    public abstract AgentLogManager getAgentLogManager();

    public abstract AgentGoodRepository getAgentGoodRepository();

    private void saveErrorLog(AgentLogManager agentLogManager, AgentType agentType,
            String message) {

        agentLogManager.save(agentType, "", message);
    }


}
