package net.yaboiiii_xd.firstmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;
import net.yaboiiii_xd.firstmod.block.ModBlocks;
import net.yaboiiii_xd.firstmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RAW_MORTEMITE_BLOCK);
        addDrop(ModBlocks.MORTEMITE_BLOCK);

        addDrop(ModBlocks.DEEPSLATE_MORTEMITE_ORE, mortemiteOreDrops(ModBlocks.DEEPSLATE_MORTEMITE_ORE, ModItems.RAW_MORTEMITE));
        addDrop(ModBlocks.SOUL_SOIL_MORTEMITE_ORE, netherMortemiteOreDrops(ModBlocks.SOUL_SOIL_MORTEMITE_ORE, ModItems.RAW_MORTEMITE));

    }

    public LootTable.Builder mortemiteOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }

    public LootTable.Builder netherMortemiteOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(3.0F, 6.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }



}
