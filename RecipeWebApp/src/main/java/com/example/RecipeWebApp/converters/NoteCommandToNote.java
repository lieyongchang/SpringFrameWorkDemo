package com.example.RecipeWebApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.RecipeWebApp.commands.NotesCommand;
import com.example.RecipeWebApp.domain.Notes;

import lombok.Synchronized;

@Component
public class NoteCommandToNote implements Converter<NotesCommand, Notes> {

	@Synchronized
	@Nullable
	@Override
	public Notes convert(NotesCommand source) {
		if (source == null) {
			return null;
		}

		final Notes notesConverter = new Notes();
		notesConverter.setId(source.getId());
		notesConverter.setRecipeNotes(source.getRecipeNotes());
		return notesConverter;
	}

}
