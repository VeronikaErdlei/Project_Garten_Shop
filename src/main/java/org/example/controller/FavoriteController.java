package org.example.controller;

import org.example.entity.Product;
import org.example.entity.User;
import org.example.service.FavoriteService;
import org.example.service.UserService;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public void addFavorite(@RequestParam Long userId, @RequestParam Long productId) {
        User user = userService.getUserById(userId);
        Product product = productService.getProductById(productId);
        favoriteService.addFavorite(user, product);
    }

    @GetMapping("/list")
    public List<Product> getFavorites(@RequestParam Long userId) {
        User user = userService.getUserById(userId);
        return favoriteService.getFavorites(user);
    }

    @PostMapping("/remove")
    public void removeFavorite(@RequestParam Long userId, @RequestParam Long productId) {
        User user = userService.getUserById(userId);
        Product product = productService.getProductById(productId);
        favoriteService.removeFavorite(user, product);
    }
}