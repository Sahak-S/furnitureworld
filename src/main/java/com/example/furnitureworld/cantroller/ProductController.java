package com.example.furnitureworld.cantroller;

import com.example.furnitureworld.entity.CreditCart;
import com.example.furnitureworld.entity.Product;
import com.example.furnitureworld.entity.ProductImage;
import com.example.furnitureworld.entity.User;
import com.example.furnitureworld.repository.CategoryRepository;
import com.example.furnitureworld.repository.CreditCartRepository;
import com.example.furnitureworld.repository.ProductImageRepository;
import com.example.furnitureworld.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Value("${furnitureworld.upload.path}")
    private String imagePhat;

    @GetMapping("/product")
    public String productPage(ModelMap map) {
        List<Product> products = productRepository.findAll();
        map.addAttribute("products", products);
        return "productPage";
    }

    @GetMapping("/product/add")
    public String addProduct(ModelMap map) {
        map.addAttribute("category", categoryRepository.findAll());
        return "saveProduct";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute Product product, @RequestParam("pictures") MultipartFile[] uploadedFiles) throws IOException {
        productRepository.save(product);
        if (uploadedFiles.length != 0) {
            for (MultipartFile uploadedFile : uploadedFiles) {
                String fileName = System.currentTimeMillis() + "_" + uploadedFile.getOriginalFilename();
                File newFile = new File(imagePhat + fileName);
                uploadedFile.transferTo(newFile);
                ProductImage productImage = ProductImage.builder()
                        .name(fileName)
                        .product(product)
                        .build();
                productImageRepository.save(productImage);
            }

        }
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product/{id}")
    public String singleProduct(@PathVariable int id, ModelMap map) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);

        map.addAttribute("category", categoryRepository.findAll());
        map.addAttribute("product", product);
        return "singleProduct";
    }


}