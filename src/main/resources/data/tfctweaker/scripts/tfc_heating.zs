import mods.tfc.api.ItemStackProvider;

<recipetype:tfc:heating>.addRecipe("metal_heating_test", <item:tfc:metal/ingot/copper>, ItemStackProvider.empty, <fluid:tfc:metal/copper>*100, 1080, false);

<recipetype:tfc:heating>.addRecipe("metal_heating_test", <item:tfc:metal/ingot/copper>, ItemStackProvider.none(<item:tfc:metal/ingot/copper>), <metal:tfc:copper>, 100, 1080, false);