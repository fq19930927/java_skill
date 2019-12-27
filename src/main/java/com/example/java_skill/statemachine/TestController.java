package com.example.java_skill.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuqiang
 * @version TestController, v0.1 2019/12/27 10:37 上午
 */
@RestController
public class TestController {
    @Autowired
    private StateMachine<States, Events> stateMachine;

    @RequestMapping("/testMachine")
    @ResponseBody
    public void testMachine() throws InterruptedException {
        stateMachine.start();
        Thread.sleep(10000);
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }

}
