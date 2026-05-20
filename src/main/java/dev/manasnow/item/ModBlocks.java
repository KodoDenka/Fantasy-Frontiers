package dev.manasnow.item;

import dev.manasnow.FantasyFrontiers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModBlocks {

    public static final Block LOAM = registerBlock("loam", new Block(Block.Properties.of()));

    public static final Block MONDO_GRASS = registerBlock("mondo_grass", new Block(Block.Properties.of()));





    private static Block registerBlock(String name, Block block) {
        registerItemBlock(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(FantasyFrontiers.MOD_ID, name), block);
    }

    private static void registerItemBlock(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(FantasyFrontiers.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));
    }

    public static void registerModBlocks() {
        FantasyFrontiers.LOGGER.info("Registering Mod Blocks for " + FantasyFrontiers.MOD_ID);
    }

}
