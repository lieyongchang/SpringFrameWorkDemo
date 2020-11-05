package com.example.RecipeWebApp.commands;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class IngredientCommand {

	private Long id;
	private Long recipeId;
	private String description;
	private BigDecimal amount;

	private UnitOfMeasureCommand uom;
}
