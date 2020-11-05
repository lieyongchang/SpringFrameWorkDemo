package com.example.RecipeWebApp.converters;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.RecipeWebApp.commands.NotesCommand;
import com.example.RecipeWebApp.domain.Notes;

class NoteCommandToNoteTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "description";

	NoteCommandToNote convter;

	@BeforeEach
	void setUp() throws Exception {
		convter = new NoteCommandToNote();
	}

	@Test
	public void test() throws Exception {
		// given
		NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(ID_VALUE);
		notesCommand.setRecipeNotes(DESCRIPTION);

		// when
		Notes notes = convter.convert(notesCommand);

		// then
		assertEquals(ID_VALUE, notes.getId());
		assertEquals(DESCRIPTION, notes.getRecipeNotes());
	}

}
