package com.example.RecipeWebApp.Service;

import java.util.Set;

import com.example.RecipeWebApp.commands.UnitOfMeasureCommand;

public interface IUnitOfMeasureService {
	Set<UnitOfMeasureCommand> listAllUoms();
}
