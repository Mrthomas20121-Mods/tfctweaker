package mrthomas20121.tfctweaker.handlers;

import com.blamejared.crafttweaker.api.recipe.handler.IRecipeHandler;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import net.dries007.tfc.common.recipes.AlloyRecipe;
import net.dries007.tfc.util.Metal;

import java.util.Map;

@IRecipeHandler.For(AlloyRecipe.class)
public class AlloyHandler implements IRecipeHandler<AlloyRecipe> {

    @Override
    public String dumpToCommandString(IRecipeManager manager, AlloyRecipe recipe) {
        StringBuilder base = new StringBuilder("<recipetype:tfc:alloy>");
        for(Map.Entry<Metal, AlloyRecipe.Range> value : recipe.getRanges().entrySet()) {
            Metal metal = value.getKey();
            AlloyRecipe.Range range = value.getValue();
            base.append(String.format("addMetal(%s, %s, %s)", metal, range.min(), range.max()));
        }
        return base.toString();
    }
}
