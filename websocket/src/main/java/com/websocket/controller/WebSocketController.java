package com.websocket.controller;

import com.websocket.bean.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author lryepoch
 * @date 2020/8/20 16:10
 * @description TODO
 */
@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, Info info) {
        if (principal.getName().equals("Xiao Ming")) {
            simpMessagingTemplate.convertAndSendToUser("Suby",
                    "/queue/notification", principal.getName() + "send message to you:"
                            + info.getInfo());
        } else {
            simpMessagingTemplate.convertAndSendToUser("Xiao Ming",
                    "/queue/notification", principal.getName() + "send message to you:"
                            + info.getInfo());
        }
    }
}
