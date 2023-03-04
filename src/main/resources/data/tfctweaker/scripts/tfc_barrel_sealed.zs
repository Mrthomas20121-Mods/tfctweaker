import mods.tfc.api.ItemStackProvider;
import mods.tfc.api.FluidStackIngredient;

// remember liquids need to be in special tfc fluid tag to be able to be used in the barrel.
<recipetype:tfc:barrel_sealed>.addRecipe("test_recipe", 10, <item:minecraft:dirt>*10, FluidStackIngredient.of(<fluid:minecraft:water>), ItemStackProvider.none(<item:minecraft:stone>));