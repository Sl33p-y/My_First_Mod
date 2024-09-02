package net.yaboiiii_xd.firstmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.yaboiiii_xd.firstmod.block.ModBlocks;

public class FirstModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JALAPENO_CROP, RenderLayer.getCutout());
    }
}
