package codenamed.tides.registry;

import codenamed.tides.Tides;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class TidesItems {

    public static final Item OCEAN_STEW = registerItem("ocean_stew",
            new Item(new Item.Settings().food(TidesFoodComponents.OCEAN_STEW).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Tides.MOD_ID, name), item);

    }




    public static void init() { }
}
