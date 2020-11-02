package com.example.RecipeWebApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.example.RecipeWebApp.commands.NotesCommand;
import com.example.RecipeWebApp.domain.Notes;

import lombok.Synchronized;

@Component
public class NoteToNoteCommand implements Converter<Notes, NotesCommand> {

	@Synchronized
	@Nullable
	@Override
	public NotesCommand convert(Notes source) {

		if (source == null) {
			return null;
		}

		final NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(source.getId());
		notesCommand.setRecipeNotes(source.getRecipeNotes());
		return notesCommand;
	}

}
