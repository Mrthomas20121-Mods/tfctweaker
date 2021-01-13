package mrthomas20121.tfctweaker;

import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Ore;
import net.dries007.tfc.api.types.Rock;
import net.dries007.tfc.objects.blocks.stone.BlockOreTFC;
import net.dries007.tfc.objects.blocks.stone.BlockRockVariant;
import net.dries007.tfc.objects.items.metal.ItemOreTFC;
import net.dries007.tfc.objects.items.metal.ItemSmallOre;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

public class OredictTweak {

    public static void registerOredicts()
    {
        for(Ore ore: TFCRegistries.ORES.getValuesCollection())
        {
            String name = getName(ore.getRegistryName().getPath());
            for(Rock rock: TFCRegistries.ROCKS.getValuesCollection())
            {
                OreDictionary.registerOre("ore"+name, new ItemStack(BlockOreTFC.get(ore, rock)));
                if(ore.getMetal() != null)
                {
                    OreDictionary.registerOre(name, ItemOreTFC.get(ore, Ore.Grade.NORMAL, 1));
                    OreDictionary.registerOre(name, ItemOreTFC.get(ore, Ore.Grade.RICH, 1));
                    OreDictionary.registerOre(name, ItemOreTFC.get(ore, Ore.Grade.POOR, 1));
                    OreDictionary.registerOre(name, ItemSmallOre.get(ore, 1));
                }

                OreDictionary.registerOre("mineral"+name, ItemOreTFC.get(ore, Ore.Grade.NORMAL, 1));
                OreDictionary.registerOre("mineral"+name, ItemOreTFC.get(ore, Ore.Grade.RICH, 1));
                OreDictionary.registerOre("mineral"+name, ItemOreTFC.get(ore, Ore.Grade.POOR, 1));
            }
        }
        for(Rock rock: TFCRegistries.ROCKS.getValuesCollection())
        {
            String name = getName(rock);
            OreDictionary.registerOre("stone"+name, BlockRockVariant.get(rock, Rock.Type.RAW));
            OreDictionary.registerOre("stone"+getCategory(rock), BlockRockVariant.get(rock, Rock.Type.RAW));
            if(rock.isFluxStone())
            {
                OreDictionary.registerOre("stoneFlux", BlockRockVariant.get(rock, Rock.Type.RAW));
            }
        }
    }

    private static String getName(String ore)
    {
        StringBuilder result = new StringBuilder();
        if(ore.contains("_"))
        {
            String[] names = ore.toLowerCase().split("_");
            if(!names[0].contains("native"))
            {
                for(String name: names)
                {
                    result.append(StringUtils.capitalize(name));
                }
            }
            else
            {
                for(int i = names.length-1; i>=0; i--)
                {
                    result.append(StringUtils.capitalize(names[i]));
                }
            }
        }
        else {
            return StringUtils.capitalize(ore);
        }
        return result.toString();
    }
    private static String getName(Rock rock)
    {
        String ore = rock.getRegistryName().getPath();
        StringBuilder result = new StringBuilder();
        if(ore.contains("_"))
        {
            String[] names = ore.split("_");
            for(String name: names)
            {
                result.append(StringUtils.capitalize(name));
            }
        }
        else {
            return StringUtils.capitalize(ore);
        }
        return result.toString();
    }
    private static String getCategory(Rock rock)
    {
        String rockCategory = rock.getRockCategory().getRegistryName().getPath();
        StringBuilder result = new StringBuilder();
        if(rockCategory.contains("_"))
        {
            String[] names = rockCategory.split("_");
            for(String name: names)
            {
                result.append(StringUtils.capitalize(name));
            }
            return StringUtils.capitalize(result.toString());
        }
        return StringUtils.capitalize(rock.getRockCategory().getRegistryName().getPath().toLowerCase());
    }
}
