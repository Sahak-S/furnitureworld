package com.example.furnitureworld.cantroller;

import com.example.furnitureworld.entity.User;
import com.example.furnitureworld.repository.UserRepository;
import com.example.furnitureworld.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/addUser")
    public String addUserPage() {
        return "account";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);
        return "account";
    }
}
