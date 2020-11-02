package com.example.RecipeWebApp.commands;

import java.util.HashSet;
import java.util.Set;

import com.example.RecipeWebApp.domain.Difficulty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RecipeCommand {
	private Long id;
	private String decription;
	private Integer prepTime;
	private Integer cookTime;
	private Integer serving;
	private String source;
	private String url;

	private String directions;

	private Set<IngredientCommand> ingredientsCommand = new HashSet<>();
	private Set<CategoryCommand> categoryCommand = new HashSet<>();
	private NotesCommand notesCommand;

	private Difficulty difficulty;
}
