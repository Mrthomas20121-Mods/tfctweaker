import mods.tfc.api.ItemStackProvider;
import mods.tfc.api.FluidStackIngredient;

<recipetype:tfc:barrel_sealed>.addRecipe("test_recipe", 10, <item:minecraft:dirt>*10, FluidStackIngredient.of(<fluid:minecraft:water>), ItemStackProvider.none(<item:minecraft:stone>));