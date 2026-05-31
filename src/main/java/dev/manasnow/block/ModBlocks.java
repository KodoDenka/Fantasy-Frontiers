package dev.manasnow.block;

import dev.manasnow.FantasyFrontiers;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block LOAM = registerBlock("loam", new Block(AbstractBlock.Settings.copy(Blocks.DIRT).mapColor(MapColor.TERRACOTTA_GRAY)));

    public static final Block MONDO_GRASS_BLOCK = registerBlock("mondo_grass_block", new MondoGrassBlock(AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK).mapColor(MapColor.BLACK)));

    public static final Block MONDO_GRASS = registerBlock("mondo_grass", new MondoGrass(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).mapColor(MapColor.BLACK)));
    public static final Block SHORT_MONDO_GRASS = registerBlock("short_mondo_grass", new MondoGrass(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS).mapColor(MapColor.BLACK)));

    public static final Block TWILIGHT_MUSHROOM_STEM = registerBlock("twilight_mushroom_stem", new Block(AbstractBlock.Settings.create()));
    public static final Block TWILIGHT_MUSHROOM_CAP = registerBlock("twilight_mushroom_cap", new Block(AbstractBlock.Settings.create()));

    public static final Block TWILIGHT_MUSHROOM = registerBlock("twilight_mushroom", new TwilightMushroom(AbstractBlock.Settings.copy(Blocks.BROWN_MUSHROOM)));
    public static final Block SUN_DROP = registerBlock("sun_drop", new TwilightMushroom(AbstractBlock.Settings.copy(Blocks.BROWN_MUSHROOM).nonOpaque()));


    private static Block registerBlock(String name, Block block) {
        registerItemBlock(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FantasyFrontiers.MOD_ID, name), block);
    }

    private static void registerItemBlock(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FantasyFrontiers.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FantasyFrontiers.LOGGER.info("Registering Mod Blocks for " + FantasyFrontiers.MOD_ID);
    }

}