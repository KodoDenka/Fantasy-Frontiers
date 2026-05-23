package dev.manasnow;

import dev.manasnow.block.ModBlocks;
import dev.manasnow.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {

    public static final CreativeModeTab FANTASY_FRONTIERS_TAB = Registry.register(
        BuiltInRegistries.CREATIVE_MODE_TAB,
        ResourceLocation.fromNamespaceAndPath(FantasyFrontiers.MOD_ID, "fantasy_frontiers_tab"),
        FabricItemGroup.builder()
            .title(Component.translatable("itemGroup.fantasy_frontiers.fantasy_frontiers_tab"))
            .icon(() -> new ItemStack(ModBlocks.LOAM))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.EXAMPLE_ITEM);
                output.accept(ModBlocks.LOAM.asItem());
                output.accept(ModBlocks.MONDO_GRASS_BLOCK.asItem());
                output.accept(ModBlocks.BRITTLEGILL_STEM.asItem());
                output.accept(ModBlocks.BRITTLEGILL_CAP.asItem());
                output.accept(ModBlocks.INK_STEM.asItem());
                output.accept(ModBlocks.INK_CAP.asItem());
                output.accept(ModBlocks.MILK_STEM.asItem());
                output.accept(ModBlocks.MILK_CAP.asItem());
            })
            .build()
    );

    public static void registerCreativeTabs() {
        FantasyFrontiers.LOGGER.info("Registering Creative Tabs for " + FantasyFrontiers.MOD_ID);
    }
}