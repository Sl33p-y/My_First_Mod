package net.yaboiiii_xd.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.yaboiiii_xd.firstmod.block.ModBlocks;
import net.yaboiiii_xd.firstmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MORTEMITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MORTEMITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MORTEMITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_MORTEMITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUL_SOIL_MORTEMITE_ORE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MORTEMITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_MORTEMITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.YUZU, Models.GENERATED);
        itemModelGenerator.register(ModItems.GILDED_COAL, Models.GENERATED);
    }
}
