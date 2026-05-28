package dev.manasnow.block;

import dev.manasnow.FantasyFrontiers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {

    public static final Block LOAM = registerBlock("loam", new Block(Block.Properties.ofFullCopy(Blocks.DIRT).mapColor(MapColor.TERRACOTTA_GRAY)));

    public static final Block MONDO_GRASS_BLOCK = registerBlock("mondo_grass_block", new MondoGrassBlock(Block.Properties.ofFullCopy(Blocks.GRASS_BLOCK).mapColor(MapColor.COLOR_BLACK)));

    public static final Block MONDO_GRASS = registerBlock("mondo_grass", new MondoGrass(Block.Properties.ofFullCopy(Blocks.SHORT_GRASS).mapColor(MapColor.COLOR_BLACK)));
    public static final Block SHORT_MONDO_GRASS = registerBlock("short_mondo_grass", new MondoGrass(Block.Properties.ofFullCopy(Blocks.SHORT_GRASS).mapColor(MapColor.COLOR_BLACK)));


    public static final Block TWILIGHT_MUSHROOM_STEM = registerBlock("twilight_mushroom_stem", new Block(Block.Properties.of()));
    public static final Block TWILIGHT_MUSHROOM_CAP = registerBlock("twilight_mushroom_cap", new Block(Block.Properties.of()));

    public static final Block TWILIGHT_MUSHROOM = registerBlock("twilight_mushroom", new TwilightMushroom(Block.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)));
    public static final Block SUN_DROP = registerBlock("sun_drop", new TwilightMushroom(Block.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM).noOcclusion()));






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
