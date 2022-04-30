package com.example.furnitureworld.cantroller;

import com.example.furnitureworld.entity.User;
import com.example.furnitureworld.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/addUser")
    public String addUserPage() {
        return "saveUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user, ModelMap map) {
        List<String> errorMsgs = new ArrayList<>();
        if (user.getName() == null || user.getName().equals("")){
            errorMsgs.add("name is required");
        }
        if (user.getSurname() == null || user.getSurname().equals("")){
            errorMsgs.add("Surname is required");
        }
        if (user.getEmail() == null || user.getEmail().equals("")){
            errorMsgs.add("name is required");
        }
        if (!errorMsgs.isEmpty()){
            map.addAttribute("errores",errorMsgs);
            return "saveUser";
        }
        userService.save(user);
        return "userPage";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
