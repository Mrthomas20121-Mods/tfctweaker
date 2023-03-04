import mods.tfc.api.ItemStackProvider;

// slab mode
<recipetype:tfc:chisel>.addRecipe("chisel_test", [<block:minecraft:oak_planks>], <block:minecraft:oka_slab>, <constant:tfc:chisel_mode:slab>, ItemStackProvider.none(<item:minecraft:oka_slab>), null);

// stair mode
<recipetype:tfc:chisel>.addRecipe("chisel_test", [<block:minecraft:oak_planks>], <block:minecraft:oka_stair>, <constant:tfc:chisel_mode:stair>, ItemStackProvider.empty, null);

// smooth mode
<recipetype:tfc:chisel>.addRecipe("chisel_test", [<block:minecraft:stone>], <block:minecraft:smooth_stone>, <constant:tfc:chisel_mode:smooth>, ItemStackProvider.empty, null);