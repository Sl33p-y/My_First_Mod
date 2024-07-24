package net.yaboiiii_xd.firstmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.yaboiiii_xd.firstmod.block.ModBlocks;
import net.yaboiiii_xd.firstmod.item.ModItemGroups;
import net.yaboiiii_xd.firstmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	public static final String MOD_ID = "first-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		FuelRegistry.INSTANCE.add(ModItems.GILDED_COAL, 2500);
		LOGGER.info("Hello Fabric world!");
	}
}