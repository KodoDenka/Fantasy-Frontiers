package dev.manasnow.item;

import dev.manasnow.FantasyFrontiers;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item EXAMPLE_ITEM = registeredItem("example_item", new Item(new Item.Settings()));


    private static Item registeredItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FantasyFrontiers.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FantasyFrontiers.LOGGER.info("Registering Mod Items for " + FantasyFrontiers.MOD_ID);
    }

}