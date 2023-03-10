package controller;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import chat.ChatRoom;
import chat.ChatRoomRepository;
 
@Controller
@RequestMapping("/multiRoom")
public class home {
 
    @GetMapping("/home")
    public String homeController(Model model, HttpServletRequest request) {
        Collection<ChatRoom> chatRooms = ChatRoomRepository.chatRooms;
        
        model.addAttribute("collection", chatRooms);
        return "game/home";
    }
    
 
}
 
