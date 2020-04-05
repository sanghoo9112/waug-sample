package com.example.demo.sample.api;

import com.example.demo.sample.good.AgentGoodBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentGoodRepository extends JpaRepository<AgentGoodBase, Long> {

    AgentGoodBase findByGoodId(long goodId);
}
