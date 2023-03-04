import mods.tfc.api.FluidStackIngredient;

// recipe name, IIngredient[] inputs, input fluid, duration, temp, output fluid, (Optional)items Output
<recipetype:tfc:pot>.addPotRecipe("test_pot_recipe", [<item:minecraft:purple_dye>], FluidStackIngredient.of(<fluid:minecraft:water>*1000), 2000, 600, <tfc:purple_dye>*1000);

// second example with item outputs
<recipetype:tfc:pot>.addPotRecipe("test_pot_recipe", [<item:minecraft:purple_dye>], FluidStackIngredient.of(<fluid:minecraft:water>*1000), 2000, 600, <tfc:purple_dye>*1000, [<item:minecraft:purple_dye>]);