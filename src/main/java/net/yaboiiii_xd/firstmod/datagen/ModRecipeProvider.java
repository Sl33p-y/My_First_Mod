package net.yaboiiii_xd.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.yaboiiii_xd.firstmod.block.ModBlocks;
import net.yaboiiii_xd.firstmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> MORTEMITE_SMELTABLES = List.of(ModItems.RAW_MORTEMITE,
            ModBlocks.MORTEMITE_ORE,
            ModBlocks.DEEPSLATE_MORTEMITE_ORE,
            ModBlocks.SOUL_SOIL_MORTEMITE_ORE);


    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerBlasting(exporter, MORTEMITE_SMELTABLES, RecipeCategory.MISC, ModItems.MORTEMITE,
                5f, 600, "mortemite");
       offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MORTEMITE, RecipeCategory.DECORATIONS, ModBlocks.MORTEMITE_BLOCK);
       offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_MORTEMITE, RecipeCategory.DECORATIONS, ModBlocks.RAW_MORTEMITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MORTEMITE_ORE, 1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('R', ModItems.RAW_MORTEMITE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.RAW_MORTEMITE), conditionsFromItem(ModItems.RAW_MORTEMITE))
                .offerTo(exporter, Identifier.tryParse((getRecipeName(ModBlocks.MORTEMITE_ORE))));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DEEPSLATE_MORTEMITE_ORE, 1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.DEEPSLATE)
                .input('R', ModItems.RAW_MORTEMITE)
                .criterion(hasItem(Items.DEEPSLATE), conditionsFromItem(Items.DEEPSLATE))
                .criterion(hasItem(ModItems.RAW_MORTEMITE), conditionsFromItem(ModItems.RAW_MORTEMITE))
                .offerTo(exporter, Identifier.tryParse((getRecipeName(ModBlocks.DEEPSLATE_MORTEMITE_ORE))));
    }
}
