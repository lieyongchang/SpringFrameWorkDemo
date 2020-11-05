package com.example.RecipeWebApp.commands;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.example.RecipeWebApp.domain.Difficulty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RecipeCommand {
	private Long id;

	@NotBlank
	@Size(min = 3, max = 255)
	private String decription;

	@Min(1)
	@Max(999)
	private Integer prepTime;

	@Min(1)
	@Max(999)
	private Integer cookTime;

	@Min(1)
	@Max(999)
	private Integer serving;
	private String source;
	private String url;
	private Byte[] image;
	private String directions;

	private Set<IngredientCommand> ingredientsCommand = new HashSet<>();
	private Set<CategoryCommand> categoryCommand = new HashSet<>();
	private NotesCommand notesCommand;

	private Difficulty difficulty;
}
