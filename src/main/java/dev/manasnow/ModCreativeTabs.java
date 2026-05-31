package dev.manasnow;

import dev.manasnow.block.ModBlocks;
import dev.manasnow.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModCreativeTabs {

    public static final ItemGroup FANTASY_FRONTIERS_TAB = Registry.register(
        Registries.ITEM_GROUP,
        Identifier.of(FantasyFrontiers.MOD_ID, "fantasy_frontiers_tab"),
        FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.fantasy_frontiers.fantasy_frontiers_tab"))
            .icon(() -> new ItemStack(ModBlocks.LOAM))
            .entries((context, entries) -> {
                entries.add(ModItems.EXAMPLE_ITEM);
                entries.add(ModBlocks.LOAM.asItem());
                entries.add(ModBlocks.MONDO_GRASS_BLOCK.asItem());
                entries.add(ModBlocks.MONDO_GRASS.asItem());
                entries.add(ModBlocks.SHORT_MONDO_GRASS.asItem());
                entries.add(ModBlocks.TWILIGHT_MUSHROOM_STEM.asItem());
                entries.add(ModBlocks.TWILIGHT_MUSHROOM_CAP.asItem());
                entries.add(ModBlocks.TWILIGHT_MUSHROOM.asItem());
                entries.add(ModBlocks.SUN_DROP.asItem());
            })
            .build()
    );

    public static void registerCreativeTabs() {
        FantasyFrontiers.LOGGER.info("Registering Creative Tabs for " + FantasyFrontiers.MOD_ID);
    }
}