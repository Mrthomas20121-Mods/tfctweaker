import mods.tfc.api.FluidStackIngredient;

// recipes using a metal
// default recipe uses 100mb of metal and return 100mb of metal
<recipetype:tfc:blast_furnace>.addRecipe("test_metal_recipe", <metal:tfc:copper>, <item:minecraft:coal>, <metal:tfc:bronze>);
// uses 200mb of copper
<recipetype:tfc:blast_furnace>.addRecipe("test_metal_recipe2", <metal:tfc:copper>, 200, <item:minecraft:coal>, <metal:tfc:bronze>, 200);

// recipe not using a metal
<recipetype:tfc:blast_furnace>.addRecipe("test_recipe", FluidStackIngredient.of(<fluid:tfc:metal/copper>*200), <item:minecraft:coal>, FluidStackIngredient.of(<fluid:tfc:metal/bronze>*200));