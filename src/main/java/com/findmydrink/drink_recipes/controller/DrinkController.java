package com.findmydrink.drink_recipes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.findmydrink.drink_recipes.model.Drink;
import com.findmydrink.drink_recipes.repository.DrinkRepository;
import com.findmydrink.drink_recipes.service.DrinkService;

@RestController
@RequestMapping("/api/drinks")
public class DrinkController {

    
    private DrinkRepository drinkRepository;

    public DrinkController(DrinkRepository drinkRepository){
        this.drinkRepository = drinkRepository;

    }
   
    @GetMapping
    public List<Drink> searchDrinks(@RequestParam String name) {
        return drinkRepository.findByNameContainingIgnoreCase(name);
    }

    @PostMapping
    public Drink createDrink(@RequestBody Drink drink) {
        return drinkRepository.save(drink);
    }

    @PutMapping("/{id}")
    public Drink updateDrink(@PathVariable Long id, @RequestBody Drink drink) {
        drink.setId(id);
        return drinkRepository.save(drink);
    }
}