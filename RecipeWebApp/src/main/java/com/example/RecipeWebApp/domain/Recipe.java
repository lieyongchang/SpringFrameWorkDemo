package com.example.RecipeWebApp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

//defines that a class can be mapped to a table
@Getter
@Setter
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
}
