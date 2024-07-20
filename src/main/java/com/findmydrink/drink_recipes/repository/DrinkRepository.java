package com.findmydrink.drink_recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.findmydrink.drink_recipes.model.Drink;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

}
