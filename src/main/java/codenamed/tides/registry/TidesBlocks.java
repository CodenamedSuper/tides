package codenamed.tides.registry;
import codenamed.tides.Tides;
import codenamed.tides.block.custom.ClamBlock;
import codenamed.tides.block.custom.MarinalOrganBlock;
import codenamed.tides.block.custom.MarinalBlock;
import codenamed.tides.block.custom.UrchinSpinesBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
public class TidesBlocks {

    public static final Block SHORESTONE = registerBlock("shorestone",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));

    public static final Block PEBBLESTONE = registerBlock("pebblestone",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool()));

    public static final Block CLAM = registerBlock("clam",
            new ClamBlock(AbstractBlock.Settings.copy(Blocks.STONE).requiresTool().ticksRandomly()));

    public static final Block URCHIN = registerBlock("urchin",
            new MarinalBlock(AbstractBlock.Settings.copy(Blocks.SPONGE)));

    public static final Block URCHIN_SPINES = registerBlock("urchin_spines",
            new UrchinSpinesBlock(7.0F, 3.0F, AbstractBlock.Settings.copy(Blocks.SPONGE)));

    public static final Block ANEMONE = registerBlock("anemone",
            new MarinalBlock(AbstractBlock.Settings.copy(Blocks.SPONGE)));

    public static final Block ANEMONE_TENTACLES = registerBlock("anemone_tentacles",
            new MarinalOrganBlock(7.0F, 3.0F, AbstractBlock.Settings.copy(Blocks.SPONGE)));

    public static final Block SPONGE_TUBES = registerBlock("sponge_tubes",
            new MarinalOrganBlock(7.0F, 3.0F, AbstractBlock.Settings.copy(Blocks.SPONGE)));

    //Coral Blocks

    //Alive
    public static final Block DEAD_LEAF_CORAL_BLOCK = registerBlock("dead_leaf_coral_block",
            new Block(AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL_BLOCK)));

    public static final Block DEAD_PLATE_CORAL_BLOCK = registerBlock("dead_plate_coral_block",
            new Block(AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL_BLOCK)));
    //Dead

    public static final Block LEAF_CORAL_BLOCK = registerBlock("leaf_coral_block",
            new CoralBlockBlock(DEAD_LEAF_CORAL_BLOCK,  AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK)));

    public static final Block PLATE_CORAL_BLOCK = registerBlock("plate_coral_block",
            new CoralBlockBlock(DEAD_PLATE_CORAL_BLOCK,AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL_BLOCK)));

    //Corals

    //Alive
    public static final Block DEAD_LEAF_CORAL = registerBlock("dead_leaf_coral",
            new DeadCoralBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL)));

    public static final Block DEAD_PLATE_CORAL = registerBlock("dead_plate_coral",
            new DeadCoralBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL)));
    //Dead

    public static final Block LEAF_CORAL = registerBlock("leaf_coral",
            new CoralBlock(DEAD_LEAF_CORAL,  AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL)));

    public static final Block PLATE_CORAL = registerBlock("plate_coral",
            new CoralBlock(DEAD_PLATE_CORAL,AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL)));

    //Coral Fans

    //Alive

    public static final Block DEAD_LEAF_CORAL_FAN = registerBlock("dead_leaf_coral_fan",
            new DeadCoralFanBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL_FAN)));

    public static final Block DEAD_PLATE_CORAL_FAN = registerBlock("dead_plate_coral_fan",
            new DeadCoralFanBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL_FAN)));

    //Dead

    public static final Block LEAF_CORAL_FAN = registerBlock("leaf_coral_fan",
            new CoralFanBlock(DEAD_LEAF_CORAL_FAN,  AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL_FAN)));

    public static final Block PLATE_CORAL_FAN = registerBlock("plate_coral_fan",
            new CoralFanBlock(DEAD_PLATE_CORAL_FAN,AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL_FAN)));

    //Coral Wall Fans

    //Alive

    public static final Block DEAD_LEAF_CORAL_WALL_FAN = registerBlock("dead_leaf_coral_wall_fan",
            new DeadCoralWallFanBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN)));

    public static final Block DEAD_PLATE_CORAL_WALL_FAN = registerBlock("dead_plate_coral_wall_fan",
            new DeadCoralWallFanBlock(AbstractBlock.Settings.copy(Blocks.DEAD_BRAIN_CORAL_WALL_FAN)));

    //Dead

    public static final Block LEAF_CORAL_WALL_FAN = registerBlock("leaf_coral_wall_fan",
            new CoralWallFanBlock(DEAD_LEAF_CORAL_WALL_FAN,  AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL_WALL_FAN)));

    public static final Block PLATE_CORAL_WALL_FAN = registerBlock("plate_coral_wall_fan",
            new CoralWallFanBlock(DEAD_PLATE_CORAL_WALL_FAN,AbstractBlock.Settings.copy(Blocks.BRAIN_CORAL_WALL_FAN)));






    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(Tides.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
        return item;
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Tides.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {

        return Registry.register(Registries.BLOCK, Identifier.of(Tides.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Tides.LOGGER.info("Registering Blocks for " + Tides.MOD_ID);
    }
}
