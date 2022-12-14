package com.example.test_case.service.impl;

import com.example.test_case.model.Cart;
import com.example.test_case.model.Item;
import com.example.test_case.repository.CartRepository;
import com.example.test_case.service.ICartService;
import com.example.test_case.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    IItemService itemService;

    @Override
    public List<Cart> findAllByCustomerId(Long id) {
        return cartRepository.findCartByCustomerId(id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void delete(Long id) {
        cartRepository.deleteById(id);
    }

}
