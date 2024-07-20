package com.findmydrink.drink_recipes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findmydrink.drink_recipes.model.Drink;
import com.findmydrink.drink_recipes.repository.DrinkRepository;

@Service
public class DrinkService {
    @Autowired
    private DrinkRepository drinkRepository;

    public Drink saveDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    public Optional<Drink> getDrink(Long id) {
        return drinkRepository.findById(id);
    }

}
