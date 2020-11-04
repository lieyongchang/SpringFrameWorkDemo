package com.example.RecipeWebApp.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageService implements IimageService {

	@Override
	public void saveImageFile(Long recipeId, MultipartFile file) {
		log.debug("Received a file");
	}

}
