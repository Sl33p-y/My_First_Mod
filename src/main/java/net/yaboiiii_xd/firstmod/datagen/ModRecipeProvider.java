package net.yaboiiii_xd.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
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
            ModBlocks.MORTEMITE_ORE, ModBlocks.DEEPSLATE_MORTEMITE_ORE, ModBlocks.SOUL_SOIL_MORTEMITE_ORE);
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerBlasting(exporter, MORTEMITE_SMELTABLES, RecipeCategory.MISC, ModItems.MORTEMITE,
                10.0f, (int) 625.2f, "mortemite");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MORTEMITE,RecipeCategory.DECORATIONS,
            ModBlocks.MORTEMITE_BLOCK);

        // Assuming you want to create a recipe in the MISC category for ModBlocks.MORTEMITE_ORE
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MORTEMITE_ORE, 1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.STONE)  // Use single quotes for characters in pattern
                .input('R', ModItems.RAW_MORTEMITE)
                .criterion("has_stone", hasItem(Items.STONE))
                .criterion("has_raw_mortemite", hasItem(ModItems.RAW_MORTEMITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.MORTEMITE_ORE)));
    }
}
