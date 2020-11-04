package com.example.RecipeWebApp.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.repositories.RecipeRepository;

class ImageServiceTest {

	@Mock
	RecipeRepository recipeRepo;

	IimageService imageService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		imageService = new ImageService(recipeRepo);
	}

	@Test
	public void saveImageFile() throws Exception {
		// given
		Long id = 1L;
		MultipartFile multipartFile = new MockMultipartFile("imagefile", "testing.txt", "text/plain",
				"Spring Framework Guru".getBytes());

		Recipe recipe = new Recipe();
		recipe.setId(id);
		Optional<Recipe> recipeOptional = Optional.of(recipe);

		when(recipeRepo.findById(anyLong())).thenReturn(recipeOptional);

		ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);

		// when
		imageService.saveImageFile(id, multipartFile);

		// then
		verify(recipeRepo, times(1)).save(argumentCaptor.capture());
		Recipe savedRecipe = argumentCaptor.getValue();
		assertEquals(multipartFile.getBytes().length, savedRecipe.getImage().length);
	}

}
