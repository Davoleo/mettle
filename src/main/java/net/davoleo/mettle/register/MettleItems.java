package net.davoleo.mettle.register;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.davoleo.mettle.api.metal.IMetal;
import net.davoleo.mettle.item.MetalWorkpiece;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

import static net.davoleo.mettle.Mettle.REGISTRATE;

public class MettleItems {

    public static final Map<IMetal, RegistryObject<Item>> ORE_CHUNKS = new HashMap<>();

    public static final RegistryEntry<Item> METAL_WORKPIECE = REGISTRATE.get()
            .object("metal_workpiece")
            .simple(Item.class, MetalWorkpiece::new);

    public static void init() {

    }

    private static void registerSimpleItem(String name)
    {
        //REGISTER.register(name, () -> new Item(new Item.Properties().tab(Mettle.CREATIVE_TAB)));
    }

    public static void registerSimpleBlockItem(MettleBlocks.BlockEntry<? extends Block> block) {
        // TODO: 30/07/2022 Maybe add to a cache
        //REGISTER.register(
        //        block.getRegistryId().getPath(),
        //        () -> new BlockItem(block.get(),
        //                new Item.Properties().tab(Mettle.CREATIVE_TAB))
        //);
    }
}
