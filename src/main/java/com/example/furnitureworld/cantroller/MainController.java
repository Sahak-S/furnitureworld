package com.example.furnitureworld.cantroller;

import com.example.furnitureworld.entity.User;
import com.example.furnitureworld.entity.UserType;
import com.example.furnitureworld.sequrity.CurrentUser;
import com.example.furnitureworld.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
public class MainController {

    @Value("${furnitureworld.upload.path}")
    private String imagePhat;

    private final UserService userService;
    @GetMapping("/")
    public String main() {
        return "index";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "account";
    }


    @GetMapping("/register")
    public String register(@ModelAttribute User user) {
        userService.save(user);
        return "account";
    }

    //    @GetMapping("/login")
//    public String loginPage(@AuthenticationPrincipal CurrentUser currentUser) {
//        if (currentUser == null) {
//            return "login";
//        }else{
//            return "/account";
//        }
//    }
//    @PostMapping("/register")
//    public String userPage() {
//        return "account";
//    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }


    @GetMapping("/successLogin")
    public String successLogin(@AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser == null) {
            return "redirect:/";
        }
        User user = currentUser.getUser();
        if (user.getType() == UserType.ADMIN) {
            return "redirect:/admin";
        } else if (user.getType() == UserType.USER) {
            return "account";
        }
        return null;
    }

    @GetMapping(value = "/getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@RequestParam("picName") String picName) throws IOException {
        InputStream inputStream = new FileInputStream(imagePhat + picName);
        return IOUtils.toByteArray(inputStream);
    }

}