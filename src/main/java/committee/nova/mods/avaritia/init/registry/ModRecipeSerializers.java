package committee.nova.mods.avaritia.init.registry;

import committee.nova.mods.avaritia.Static;
import committee.nova.mods.avaritia.common.crafting.condition.InfinityCatalystCondition;
import committee.nova.mods.avaritia.common.crafting.recipe.CompressorRecipe;
import committee.nova.mods.avaritia.common.crafting.recipe.ShapedExtremeCraftingRecipe;
import committee.nova.mods.avaritia.common.crafting.recipe.ShapelessExtremeCraftingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * Name: Avaritia-forge / ModRecipeSerializers
 * Author: cnlimiter
 * CreateTime: 2023/9/8 22:27
 * Description:
 */
@Mod.EventBusSubscriber
public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Static.MOD_ID);
    //public static final RegistryObject<RecipeSerializer<?>> INFINITY_SERIALIZER = serializer("infinity_catalyst", InfinityCatalystRecipe.Serializer::new);
    public static RegistryObject<RecipeSerializer<?>> SHAPED_EXTREME_CRAFT_SERIALIZER = serializer("shaped_extreme_craft", ShapedExtremeCraftingRecipe.Serializer::new);
    public static RegistryObject<RecipeSerializer<?>> SHAPELESS_EXTREME_CRAFT_SERIALIZER = serializer("shapeless_extreme_craft", ShapelessExtremeCraftingRecipe.Serializer::new);
    public static RegistryObject<RecipeSerializer<?>> COMPRESSOR_SERIALIZER = serializer("compressor", CompressorRecipe.Serializer::new);


    public static RegistryObject<RecipeSerializer<?>> serializer(String name, Supplier<RecipeSerializer<?>> serializer) {
        return SERIALIZERS.register(name, serializer);
    }

    @SubscribeEvent
    public static void registerRecipeSerializers(RegisterEvent event){
        if (event.getRegistryKey().equals(ForgeRegistries.Keys.RECIPE_SERIALIZERS)){
            CraftingHelper.register(InfinityCatalystCondition.Serializer.INSTANCE);
        }
    }

}