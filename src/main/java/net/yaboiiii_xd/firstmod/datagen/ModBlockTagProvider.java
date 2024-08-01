package net.yaboiiii_xd.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.yaboiiii_xd.firstmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_MORTEMITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_MORTEMITE_ORE);
       getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
               .add(ModBlocks.MORTEMITE_BLOCK)
               .add(ModBlocks.SOUL_SOIL_MORTEMITE_ORE);
       getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")))
               .add(Blocks.BEDROCK);


    }
}
