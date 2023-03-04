import mods.tfc.api.ItemStackProvider;

// recipe name, input, min anvil tier, array of Forge rules, boolean applyForgingBonus, output
<recipetype:tfc:anvil>.addRecipe("anvil_test", <tfc:metal/ingot/copper>, 1, [<constant:tfc:forge_rule:hit_any>, <constant:tfc:forge_rule:draw_not_last>, <constant:tfc:forge_rule:hit_any>], true, ItemStackProvider.copyForgingBonus(<tfc:metal/chisel_head/copper>));