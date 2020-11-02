package com.example.RecipeWebApp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//defines that a class can be mapped to a table
@Data
@Entity
public class Recipe {

	/*
	 * @Id = the member field below is the primary key of current entity.
	 * 
	 * 
	 * @GeneratedValue = configure the way of increment of the specified
	 * column(field)
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer serving;
	private String source;
	private String url;

	@Lob
	private String directions;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();

	@Lob
	private Byte[] image;

	// JPA will use the string value when persisting a given entity in the
	// database.
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;

	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;

	@ManyToMany
	@JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

	public Recipe() {
	}

	public Recipe addIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this);
		this.ingredients.add(ingredient);
		return this;
	}

	protected boolean canEqual(final Object other) {
		return other instanceof Recipe;
	}

}
