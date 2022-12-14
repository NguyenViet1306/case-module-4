package com.example.test_case.controller;

import com.example.test_case.model.Cart;
import com.example.test_case.model.Item;
import com.example.test_case.model.Product;
import com.example.test_case.service.ICartService;
import com.example.test_case.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/carts")
public class CartController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IItemService itemService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findByCustomerId(@PathVariable Long id) {
        return new ResponseEntity<>(iCartService.findAllByCustomerId(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Cart> createCart(@RequestBody Cart cart){
        return new ResponseEntity<>(iCartService.save(cart),HttpStatus.CREATED);
    }

    @GetMapping
    private ResponseEntity<List<Cart>> getAll() {
        return new ResponseEntity<>(iCartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/item")
    private ResponseEntity<List<Item>> getAllItem() {
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }


    // Tìm kiếm List Item theo Id người dùng
    @GetMapping("/item/{idCustomer}")
    private ResponseEntity<List<Item>> findItemByCustomerId(@PathVariable Long idCustomer) {
        return new ResponseEntity<>(itemService.findItemByCustomerId(idCustomer), HttpStatus.OK);
    }


    // Xóa Item khỏi giỏ hàng
    @DeleteMapping("/item/{idItem}")
    private ResponseEntity<Void> deleteItemById(@PathVariable Long idItem) {
        itemService.delete(idItem);
        return new ResponseEntity<>( HttpStatus.OK);
    }


    // Thêm Item vào giỏ hàng
    @PostMapping("/item")
    private ResponseEntity<Item> createItem(@RequestBody Item item){
        return new ResponseEntity<>(itemService.save(item),HttpStatus.CREATED);
    }


    @PutMapping("/item")
    private ResponseEntity<Item> updateProduct(@RequestBody Item item){
        Optional<Item> optionalItem = itemService.findById(item.getId());
        if(optionalItem.isPresent()){
            return new ResponseEntity<>(itemService.save(item),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
