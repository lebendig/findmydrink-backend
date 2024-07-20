package com.findmydrink.drink_recipes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findmydrink.drink_recipes.model.Drink;
import com.findmydrink.drink_recipes.repository.DrinkRepository;

@RestController
@RequestMapping("/api/drinks")
public class DrinkController {

      @Autowired
    private DrinkRepository drinkRepository;

    @GetMapping
    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Drink> getDrinkById(@PathVariable Long id) {
        return drinkRepository.findById(id);
    }

    @PostMapping
    public Drink createDrink(@RequestBody Drink drink) {
        return drinkRepository.save(drink);
    }

    @PutMapping("/{id}")
    public Drink updateDrink(@PathVariable Long id, @RequestBody Drink drinkDetails) {
        Drink drink = drinkRepository.findById(id).orElseThrow();
        drink.setName(drinkDetails.getName());
        drink.setRecipe(drinkDetails.getRecipe());
        return drinkRepository.save(drink);
    }

    @DeleteMapping("/{id}")
    public void deleteDrink(@PathVariable Long id) {
        drinkRepository.deleteById(id);
    }
}
