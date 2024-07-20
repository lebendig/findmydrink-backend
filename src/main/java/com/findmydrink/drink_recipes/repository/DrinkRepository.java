package com.findmydrink.drink_recipes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findmydrink.drink_recipes.model.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findByNameContainingIgnoreCase(String name);
}
    
