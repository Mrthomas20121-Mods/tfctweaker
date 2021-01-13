# Fluids

## Package
```zenscript
import mods.tfctweaker.fluids;
```

## Addition

```zenscript
fluids.makeDrinkable(ILiquidStack liquid,float thirst);
fluids.makeDrinkable(ILiquidStack liquid,float thirst, String potion, int duration, int level);
```

## examples

```zenscript
fluids.makeDrinkable(<liquid:lava>, -100);
fluids.makeDrinkable(<liquid:milk>, 5, "minecraft:resistance", 100, 1);