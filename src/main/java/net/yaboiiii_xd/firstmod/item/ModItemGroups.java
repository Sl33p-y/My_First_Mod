package net.yaboiiii_xd.firstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yaboiiii_xd.firstmod.FirstMod;
import net.yaboiiii_xd.firstmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup FIRST_MOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FirstMod.MOD_ID, "first-mod_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.first-mod"))
                    .icon(() -> new ItemStack(ModItems.MORTEMITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.MORTEMITE);
                        entries.add(ModItems.RAW_MORTEMITE);
                        entries.add(ModBlocks.MORTEMITE_BLOCK);
                        entries.add(ModBlocks.RAW_MORTEMITE_BLOCK);
                        entries.add(ModItems.YUZU);
                        entries.add(ModItems.GILDED_COAL);
                        entries.add(ModItems.MORTEMITE_PICKAXE);
                        entries.add(ModItems.MORTEMITE_LONGSWORD);
                        entries.add(ModItems.MORTEMITE_AXE);
                        entries.add(ModBlocks.DEEPSLATE_MORTEMITE_ORE);
                        entries.add(ModBlocks.SOUL_SOIL_MORTEMITE_ORE);
                    }).build());

    public static void registerItemGroups() {
        FirstMod.LOGGER.info("Registering Item Groups for " + FirstMod.MOD_ID);
    }
}
