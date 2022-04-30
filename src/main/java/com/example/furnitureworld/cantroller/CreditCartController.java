package com.example.furnitureworld.cantroller;

import com.example.furnitureworld.entity.CreditCart;
import com.example.furnitureworld.repository.CreditCartRepository;
import com.example.furnitureworld.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CreditCartController {

    @Autowired
    private CreditCartRepository creditCartRepository;


    @GetMapping("/creditCart")
    public String creditCart() {
        return "creditCart";
    }
    @PostMapping ("/creditCart")
    public String creditCartPage(@ModelAttribute CreditCart creditCart) {
//
//        if (creditCart.getOwnersName() == null || creditCart.getOwnersName().equals("")){
//            errorMsgs.add("name is required");
//        }
//        if (user.getSurname() == null || user.getSurname().equals("")){
//            errorMsgs.add("Surname is required");
//        }
//        if (user.getEmail() == null || user.getEmail().equals("")){
//            errorMsgs.add("name is required");
//        }
//        if (creditCart.getCartCode().equals())
//        creditCartRepository.save(creditCart);
        return "creditCart";
    }
}
