package dev.manasnow.client;

import dev.manasnow.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class FantasyFrontiersClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TWILIGHT_MUSHROOM, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUN_DROP, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONDO_GRASS, RenderType.cutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHORT_MONDO_GRASS, RenderType.cutout());
	}
}