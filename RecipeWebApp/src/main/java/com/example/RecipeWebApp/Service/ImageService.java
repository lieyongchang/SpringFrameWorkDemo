package com.example.RecipeWebApp.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageService implements IimageService {

	private final RecipeRepository recipeRepo;

	public ImageService(RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
	}

	@Override
	@Transactional
	public void saveImageFile(Long recipeId, MultipartFile file) {
		try {
			Recipe recipe = recipeRepo.findById(recipeId).get();

			Byte[] byteObjects = new Byte[file.getBytes().length];

			int i = 0;

			for (byte b : file.getBytes()) {
				byteObjects[i++] = b;
			}

			recipe.setImage(byteObjects);

			recipeRepo.save(recipe);
		} catch (IOException e) {
			// todo handle better
			log.error("Error occurred", e);

			e.printStackTrace();
		}
	}

}
