package net.yaboiiii_xd.firstmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yaboiiii_xd.firstmod.FirstMod;

public class ModBlocks {
    public static final Block MORTEMITE_BLOCK = registerBlock("mortemite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).hardness(55)));
    public static final Block RAW_MORTEMITE_BLOCK = registerBlock("raw_mortemite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).hardness(45)));
    public static final Block MORTEMITE_ORE = registerBlock("mortemite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).hardness(40)));
    public static final Block SOUL_SOIL_MORTEMITE_ORE = registerBlock("nether_mortemite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).hardness(40)));
    public static final Block DEEPSLATE_MORTEMITE_ORE = registerBlock("deepslate_mortemite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).hardness(45)));



    private static Block registerBlock (String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, name), block);
    }

    public static Item registerBlockItem (String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }


    public static void registerModBlocks() {
        FirstMod.LOGGER.info("Registering Mob Blocks for" + FirstMod.MOD_ID);

    }
}
