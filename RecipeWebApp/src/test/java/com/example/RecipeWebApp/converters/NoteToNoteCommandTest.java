package com.example.RecipeWebApp.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.RecipeWebApp.commands.NotesCommand;
import com.example.RecipeWebApp.domain.Notes;

class NoteToNoteCommandTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "description";

	NoteToNoteCommand convter;

	@BeforeEach
	void setUp() throws Exception {
		convter = new NoteToNoteCommand();
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(convter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(convter.convert(new Notes()));
	}

	@Test
	public void convert() throws Exception {
		// given
		Notes notes = new Notes();
		notes.setId(ID_VALUE);
		notes.setRecipeNotes(DESCRIPTION);

		// when
		NotesCommand notesCommand = convter.convert(notes);

		// then
		assertEquals(ID_VALUE, notesCommand.getId());
		assertEquals(DESCRIPTION, notesCommand.getRecipeNotes());

	}

}
