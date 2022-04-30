package com.example.furnitureworld.cantroller;

import com.example.furnitureworld.sequrity.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
@ControllerAdvice
public class MyControllerAdvice {

    @ModelAttribute
    public CurrentUser currentUser (@AuthenticationPrincipal CurrentUser currentUser){
        if (currentUser!=null){
            return currentUser;
        }
        return null;
    }
}
