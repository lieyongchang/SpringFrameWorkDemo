package com.example.RecipeWebApp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NotesCommand {
	private Long id;

	// no need @Lod?
	private String recipeNotes;
}
