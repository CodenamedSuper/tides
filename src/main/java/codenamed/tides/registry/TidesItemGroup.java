package codenamed.tides.registry;
import codenamed.tides.Tides;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TidesItemGroup {
    public static ItemGroup TIDES_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Tides.MOD_ID, "tides"),
            FabricItemGroup.builder().displayName(Text.translatable("Tides"))
                    .icon(() -> new ItemStack(TidesBlocks.CLAM)).entries((displayContext, entries) -> {

                        entries.add(TidesBlocks.SHORESTONE);
                        entries.add(TidesBlocks.PEBBLESTONE);
                        entries.add(TidesBlocks.PLATE_CORAL_BLOCK);
                        entries.add(TidesBlocks.LEAF_CORAL_BLOCK);
                        entries.add(TidesBlocks.DEAD_PLATE_CORAL_BLOCK);
                        entries.add(TidesBlocks.DEAD_LEAF_CORAL_BLOCK);
                        entries.add(TidesBlocks.PLATE_CORAL);
                        entries.add(TidesBlocks.LEAF_CORAL);
                        entries.add(TidesBlocks.DEAD_PLATE_CORAL);
                        entries.add(TidesBlocks.DEAD_LEAF_CORAL);
                        entries.add(TidesBlocks.PLATE_CORAL_FAN);
                        entries.add(TidesBlocks.LEAF_CORAL_FAN);
                        entries.add(TidesBlocks.DEAD_PLATE_CORAL_FAN);
                        entries.add(TidesBlocks.DEAD_LEAF_CORAL_FAN);
                        entries.add(Blocks.SPONGE);
                        entries.add(TidesBlocks.SPONGE_TUBES);
                        entries.add(TidesBlocks.URCHIN);
                        entries.add(TidesBlocks.URCHIN_SPINES);
                        entries.add(TidesBlocks.ANEMONE);
                        entries.add(TidesBlocks.ANEMONE_TENTACLES);
                        entries.add(TidesBlocks.CLAM);
                        entries.add(TidesItems.OCEAN_STEW);


                    }).build());

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

        });
    }
}
