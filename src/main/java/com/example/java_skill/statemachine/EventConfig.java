package com.example.java_skill.statemachine;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @author fuqiang
 * @version EventConfig, v0.1 2019/12/27 10:40 上午
 */
@WithStateMachine
public class EventConfig {
    @OnTransition(target = "UNPAID")
    public void create() {
        System.out.println("-------订单创建，待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void pay() {
        System.out.println("---------用户完成支付，待收货");
    }

    @OnTransition(source = "WAITING_FOR_RECEIVE", target = "DONE")
    public void receive() {
        System.out.println("---------用户已收货，订单完成");
    }
}
