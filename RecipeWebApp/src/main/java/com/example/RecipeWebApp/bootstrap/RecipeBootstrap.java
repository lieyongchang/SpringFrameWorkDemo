package com.example.RecipeWebApp.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.RecipeWebApp.domain.Category;
import com.example.RecipeWebApp.domain.Difficulty;
import com.example.RecipeWebApp.domain.Ingredient;
import com.example.RecipeWebApp.domain.Notes;
import com.example.RecipeWebApp.domain.Recipe;
import com.example.RecipeWebApp.domain.UnitOfMeasure;
import com.example.RecipeWebApp.repositories.CategoryRepository;
import com.example.RecipeWebApp.repositories.RecipeRepository;
import com.example.RecipeWebApp.repositories.UnitOfMeasureRepository;

import lombok.extern.slf4j.Slf4j;

// create logger file
@Slf4j
// just saying this file is a component
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepo;
	private final RecipeRepository recipeRepo;
	private final UnitOfMeasureRepository uomRepo;

	public RecipeBootstrap(CategoryRepository categoryRepo, RecipeRepository recipeRepo,
			UnitOfMeasureRepository uomRepo) {
		this.categoryRepo = categoryRepo;
		this.recipeRepo = recipeRepo;
		this.uomRepo = uomRepo;
	}

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeRepo.saveAll(getRecipes());
		log.debug("Loading Bootstrap Data");
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
		if (!eachUom.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}
		Optional<UnitOfMeasure> tableSpoonUom = uomRepo.findByDescription("Tablespoon");
		if (!tableSpoonUom.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}
		Optional<UnitOfMeasure> teaSpoonUom = uomRepo.findByDescription("Teaspoon");
		if (!teaSpoonUom.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}
		Optional<UnitOfMeasure> dashUom = uomRepo.findByDescription("Dash");
		if (!dashUom.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}
		Optional<UnitOfMeasure> pintUom = uomRepo.findByDescription("Pint");
		if (!pintUom.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}
		Optional<UnitOfMeasure> cupsUom = uomRepo.findByDescription("Cup");
		if (!cupsUom.isPresent()) {
			throw new RuntimeException("Expected UOM Not Found");
		}
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
		if (!americanCat.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}
		Optional<Category> mexicanCat = categoryRepo.findByDescription("Mexican");
		if (!mexicanCat.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}
		// after get the correct data
		// store it in a variable
		Category americanCategory = americanCat.get();
		Category mexicanCategory = mexicanCat.get();

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
		guacRecipe.setNotes(guacNotes);

		guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), each));
		guacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(".5"), teaSpoon));
		guacRecipe.getIngredients()
				.add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoon));
		guacRecipe.getIngredients()
				.add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoon));
		guacRecipe.getIngredients()
				.add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each));
		guacRecipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), tableSpoon));
		guacRecipe.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(2), dash));
		guacRecipe.getIngredients()
				.add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), each));

		guacRecipe.getCategories().add(americanCategory);
		guacRecipe.getCategories().add(mexicanCategory);

		// add to return list
		recipe.add(guacRecipe);

		// Yummy Tacos
		Recipe tacosRecipe = new Recipe();
		tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
		tacosRecipe.setCookTime(9);
		tacosRecipe.setPrepTime(20);
		tacosRecipe.setDifficulty(Difficulty.MODERATE);

		tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n"
				+ "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n"
				+ "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" + "\n"
				+ "\n"
				+ "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n"
				+ "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n"
				+ "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n"
				+ "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n"
				+ "\n" + "\n"
				+ "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

		Notes tacoNotes = new Notes();
		tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n"
				+ "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n"
				+ "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n"
				+ "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n"
				+ "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n"
				+ "\n" + "\n"
				+ "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

		tacosRecipe.setNotes(tacoNotes);

		tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tableSpoon));
		tacosRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoon));
		tacosRecipe.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoon));
		tacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaSpoon));
		tacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), teaSpoon));
		tacosRecipe.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), each));
		tacosRecipe.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSpoon));
		tacosRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoon));
		tacosRecipe.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tableSpoon));
		tacosRecipe.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tableSpoon));
		tacosRecipe.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), each));
		tacosRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cups));
		tacosRecipe.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), each));
		tacosRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), each));
		tacosRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pint));
		tacosRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), each));
		tacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), each));
		tacosRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cups));
		tacosRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), each));

		tacosRecipe.getCategories().add(americanCategory);
		tacosRecipe.getCategories().add(mexicanCategory);

		recipe.add(tacosRecipe);

		return recipe;

	}

}
