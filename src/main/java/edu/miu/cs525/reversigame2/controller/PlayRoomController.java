package edu.miu.cs525.reversigame2.controller;

import edu.miu.cs525.reversigame2.model.*;
import edu.miu.cs525.reversigame2.service.PlayRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PlayRoomController {

    @Autowired
    private PlayRoomService playRoomService;

    @MessageMapping("/register")
    @SendTo("/topic/start")
    public PlayRoom register(String username) {
        playRoomService.startGame();
        return playRoomService.registerPlayer(username);
    }

    @MessageMapping("/move")
    @SendTo("/topic/move")
    public PlayRoom move(MoveDetails details) throws Exception {
        return playRoomService.move(details);
    }

}
