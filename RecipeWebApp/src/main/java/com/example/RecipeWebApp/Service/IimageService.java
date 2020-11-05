package com.example.RecipeWebApp.Service;

import org.springframework.web.multipart.MultipartFile;

public interface IimageService {
	void saveImageFile(Long recipeId, MultipartFile file);
}
