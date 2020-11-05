package com.example.RecipeWebApp.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.RecipeWebApp.Service.IRecipeService;
import com.example.RecipeWebApp.Service.IimageService;
import com.example.RecipeWebApp.commands.RecipeCommand;

@Controller
public class imageController {
	private final IimageService imgService;
	private final IRecipeService recipeService;

	public imageController(IimageService imgService, IRecipeService recipeService) {
		this.imgService = imgService;
		this.recipeService = recipeService;
	}

	@GetMapping("recipe/{id}/image")
	public String showUploadForm(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
		System.out.println("showUploadForm");
		return "recipe/imageuploadform";
	}

	@PostMapping("recipe/{id}/image")
	public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {

		imgService.saveImageFile(Long.valueOf(id), file);
		System.out.println("handleImagePost");
		return "redirect:/recipe/" + id + "/show";
	}

	@GetMapping("recipe/{id}/recipeimage")
	public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
		RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));

		if (recipeCommand.getImage() != null) {
			byte[] byteArray = new byte[recipeCommand.getImage().length];
			int i = 0;

			for (Byte wrappedByte : recipeCommand.getImage()) {
				byteArray[i++] = wrappedByte; // auto unboxing
			}

			response.setContentType("image/jpeg");
			InputStream is = new ByteArrayInputStream(byteArray);
			IOUtils.copy(is, response.getOutputStream());
		}

		if (recipeCommand.getImage() == null) {
			System.out.println("kosong");
		}
	}
}
