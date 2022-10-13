/**
 * TFC Heating Recipes
 * the last boolean is optional.
 */

<recipetype:tfc:heating>.addRecipe("heating_test", <item:tfc:food/bear>, <item:tfc:food/cooked_bear>, 200, false);

<recipetype:tfc:heating>.addRecipe("metal_heating_test", <item:tfc:metal/ingot/copper>, <fluid:tfc:metal/copper>*100, 1080);

<recipetype:tfc:heating>.addRecipe("fluid_and_item_output", <item:tfc:metal/fishing_rod/copper>, <item:tfc:metal/ingot/copper>, <fluid:tfc:metal/copper>*100, 200, false);