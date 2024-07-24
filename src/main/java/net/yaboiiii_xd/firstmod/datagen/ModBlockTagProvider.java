package net.yaboiiii_xd.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yaboiiii_xd.firstmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider<Block> {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        if (wrapperLookup == null) {
            return; // Handle the case where wrapperLookup is null
        }

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_MORTEMITE_BLOCK)
                .add(ModBlocks.MORTEMITE_BLOCK)
                .add(ModBlocks.MORTEMITE_ORE)
                .add(ModBlocks.DEEPSLATE_MORTEMITE_ORE)
                .add(ModBlocks.SOUL_SOIL_MORTEMITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_MORTEMITE_BLOCK)
                .add(ModBlocks.MORTEMITE_ORE)
                .add(ModBlocks.DEEPSLATE_MORTEMITE_ORE)
                .add(ModBlocks.SOUL_SOIL_MORTEMITE_ORE);

        // Create a tag builder for a custom tag
        FabricTagProvider<Block>.FabricTagBuilder tagBuilder = getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")));
        tagBuilder.add(ModBlocks.MORTEMITE_BLOCK);
    }
}

