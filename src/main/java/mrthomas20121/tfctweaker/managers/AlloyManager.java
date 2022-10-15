package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.recipes.AlloyRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * TFC Heating Recipes
 *
 * @docParam this <recipetype:tfc:heating>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.alloy")
@Document("mods/tfctweaker/AlloyManager")
public class AlloyManager implements IRecipeManager<AlloyRecipe> {

    private final Map<Metal, AlloyRecipe.Range> metals = new HashMap<>();

    @Override
    public RecipeType<AlloyRecipe> getRecipeType() {
        return TFCRecipeTypes.ALLOY.get();
    }

    @ZenCodeType.Method
    public AlloyManager addMetal(String metalName, int min, int max) {
        Metal metal = Metal.MANAGER.get(new ResourceLocation(metalName));
        AlloyRecipe.Range range = new AlloyRecipe.Range(min, max);
        metals.put(metal, range);
        return this;
    }

    @ZenCodeType.Method
    public void create(String name, String outputMetal) {
        Metal metal = Metal.MANAGER.get(new ResourceLocation(outputMetal));
        addRecipe(Helpers.identifier(name), () -> this.metals, () -> metal);
    }

    public void addRecipe(ResourceLocation name, Supplier<Map<Metal, AlloyRecipe.Range>> metals, Supplier<Metal> outputMetal) {
        AlloyRecipe recipe = new AlloyRecipe(name, metals, outputMetal);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe));
    }
}
