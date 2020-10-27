package com.example.RecipeWebApp.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.RecipeWebApp.domain.Category;
import com.example.RecipeWebApp.domain.Difficulty;
import com.example.RecipeWebApp.domain.Ingredient;
import com.example.RecipeWebApp.domain.Notes;
import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.domain.UnitOfMeasure;
import com.example.RecipeWebApp.repositories.CategoryRepository;
import com.example.RecipeWebApp.repositories.RecipeRepository;
import com.example.RecipeWebApp.repositories.UnitOfMeasureRepository;

public class RecipeBootstrap {

	private final CategoryRepository categoryRepo;
	private final RecipeRepository recipeRepo;
	private final UnitOfMeasureRepository uomRepo;

	public RecipeBootstrap(CategoryRepository categoryRepo, RecipeRepository recipeRepo,
			UnitOfMeasureRepository uomRepo) {
		this.categoryRepo = categoryRepo;
		this.recipeRepo = recipeRepo;
		this.uomRepo = uomRepo;
	}

	/*
	 * Method to retrieve recipes
	 */
	private List<Recipe> getRecipes() {

		// container to store all the recipes
		List<Recipe> recipe = new ArrayList<>(2);

		/*
		 * 
		 * This is for retrieving Unit of Measure
		 * 
		 */

		// 1) go into unit of measure repository
		// 2) Retrieve the the specific data by description
		Optional<UnitOfMeasure> eachUom = uomRepo.findByDescription("Each");
		Optional<UnitOfMeasure> tableSpoonUom = uomRepo.findByDescription("Tablespoon");
		Optional<UnitOfMeasure> teaSpoonUom = uomRepo.findByDescription("Teaspoon");
		Optional<UnitOfMeasure> dashUom = uomRepo.findByDescription("Dash");
		Optional<UnitOfMeasure> pintUom = uomRepo.findByDescription("Pint");
		Optional<UnitOfMeasure> cupsUom = uomRepo.findByDescription("Cup");

		// after get the correct data
		// store it in a variable
		UnitOfMeasure each = eachUom.get();
		UnitOfMeasure tableSpoon = tableSpoonUom.get();
		UnitOfMeasure teaSpoon = teaSpoonUom.get();
		UnitOfMeasure dash = dashUom.get();
		UnitOfMeasure pint = pintUom.get();
		UnitOfMeasure cups = cupsUom.get();

		/*
		 * 
		 * This is to retrieve Category
		 * 
		 */
		// 1) go into unit of measure repository
		// 2) Retrieve the the specific data by description
		Optional<Category> americanCat = categoryRepo.findByDescription("American");
		Optional<Category> italyCat = categoryRepo.findByDescription("Italian");
		Optional<Category> mexicanCat = categoryRepo.findByDescription("Mexican");
		Optional<Category> fastfoodCat = categoryRepo.findByDescription("Fast Food");

		// after get the correct data
		// store it in a variable
		Category americanCategory = americanCat.get();
		Category itayCategory = italyCat.get();
		Category mexicanCategory = mexicanCat.get();
		Category fastfoodCategoy = fastfoodCat.get();

		/*
		 * 
		 * This is to set the recipe
		 * 
		 */

		Recipe guacRecipe = new Recipe();
		guacRecipe.setDescription("Must try it with Tacos");
		guacRecipe.setPrepTime(10);
		guacRecipe.setCookTime(0);
		guacRecipe.setDifficulty(Difficulty.EASY);

		guacRecipe.setDirections(
				"1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon"
						+ "\n"
						+ "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)"
						+ "\n"
						+ "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n"
						+ "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n"
						+ "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n"
						+ "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n"
						+ "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n"
						+ "\n" + "\n"
						+ "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

		// Notes
		Notes guacNotes = new Notes();
		guacNotes.setRecipeNotes(
				"For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n"
						+ "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n"
						+ "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n"
						+ "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n"
						+ "\n" + "\n"
						+ "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
		guacNotes.setRecipe(guacRecipe);
		guacRecipe.setNotes(guacNotes);

		guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), each, guacRecipe));
		guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(".5"), teaSpoon, guacRecipe));
		guacRecipe.getIngredients()
				.add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoon, guacRecipe));
		guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion",
				new BigDecimal(2), tableSpoon, guacRecipe));
		guacRecipe.getIngredients().add(
				new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each, guacRecipe));
		guacRecipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), tableSpoon, guacRecipe));
		guacRecipe.getIngredients()
				.add(new Ingredient("freshly grated black pepper", new BigDecimal(2), dash, guacRecipe));
		guacRecipe.getIngredients().add(
				new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), each, guacRecipe));

		guacRecipe.getCategories().add(americanCategory);
		guacRecipe.getCategories().add(mexicanCategory);

		// add to return list
		recipe.add(guacRecipe);

		return recipe;

	}
}
