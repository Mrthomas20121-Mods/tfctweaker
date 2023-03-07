package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.common.recipes.AlloyRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @docParam this <recipetype:tfc:alloy>
 */
@ZenRegister
@ZenCodeType.Name(Constants.CLASS_ALLOY)
@Document("mods/TFCTweaker/AlloyRecipe")
public class AlloyManager implements IRecipeManager<AlloyRecipe> {

    @Override
    public RecipeType<AlloyRecipe> getRecipeType() {
        return TFCRecipeTypes.ALLOY.get();
    }

    /**
     * Add an alloy recipe
     * @param name recipe name
     * @param consumer builder
     *
     * @docParam name "alloy_test"
     * @docParam consumer (alloy) => {
     *    alloy.Add("tfc:tin", 0.08, 0.12);
     *    alloy.Add("tfc:copper", 0.88, 0.92);
     *    alloy.Output("tfc:bronze");
     *    // can also do it this way
     *    // alloy.Add(<metal:tfc:tin>, 0.08, 0.12);
     *    // alloy.Add(<metal:tfc:copper>, 0.88, 0.92);
     *    // alloy.Output(<metal:tfc:bronze>);
     * }
     */
    @ZenCodeType.Method
    public void addRecipe(String name, Consumer<AlloyBuilder> consumer) {
        AlloyBuilder builder = new AlloyBuilder();
        consumer.accept(builder);
        addRecipe(Helpers.identifier(name), builder.getMetals(), builder.getOutput());
    }

    public void addRecipe(ResourceLocation name, Supplier<Map<Metal, AlloyRecipe.Range>> metals, Supplier<Metal> outputMetal) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new AlloyRecipe(name, metals, outputMetal)));
    }

}
