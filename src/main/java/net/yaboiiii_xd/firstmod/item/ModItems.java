package net.yaboiiii_xd.firstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yaboiiii_xd.firstmod.FirstMod;

public class ModItems {
    public static final Item MORTEMITE = registerItem("mortemite",
            new Item(new Item.Settings()));
    public static final Item RAW_MORTEMITE = registerItem("raw_mortemite",
            new Item(new Item.Settings()));
    public static final Item GILDED_COAL = registerItem("gilded_coal",
            new Item(new Item.Settings()));
    public static final Item YUZU = registerItem("yuzu",
            new Item(new Item.Settings().food(ModFoodComponents.YUZU)));
    /*
        public static final Item MORTEMITE_PICKAXE = registerItem("mortemite_pickaxe",
            new PickaxeItem(ModToolMaterial.MORTEMITE, new Item.Settings()));
        public static final Item MORTEMITE_LONGSWORD = registerItem("mortemite_longsword",
           new SwordItem(ModToolMaterial.MORTEMITE, new Item.Settings()));
        public static final Item MORTEMITE_AXE = registerItem("mortemite_axe",
           new AxeItem(ModToolMaterial.MORTEMITE, new Item.Settings()));
        */
    private static void addItemsToIngredientGroup(FabricItemGroupEntries entries) {
        entries.add(MORTEMITE);
        entries.add(RAW_MORTEMITE);
        entries.add(YUZU);
    }

    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FirstMod.LOGGER.info("Registering Mod Items For" + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientGroup);
    }







    public static void RegisterModItems () {
        FirstMod.LOGGER.info("Registering Mod Items for" + FirstMod.MOD_ID);
    }
}
