package dev.manasnow.item;

import dev.manasnow.FantasyFrontiers;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item EXAMPLE_ITEM = registeredItem("example_item", new Item(new Item.Properties()));


    private static Item registeredItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(FantasyFrontiers.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FantasyFrontiers.LOGGER.info("Registering Mod Items for " + FantasyFrontiers.MOD_ID);
    }

}
