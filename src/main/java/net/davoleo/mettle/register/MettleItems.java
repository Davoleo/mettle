package net.davoleo.mettle.register;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.davoleo.mettle.api.MettleAPI;
import net.davoleo.mettle.item.MetalWorkpiece;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

import static net.davoleo.mettle.Mettle.REGISTRATE;

public class MettleItems {

    public static final Map<ResourceLocation, ItemEntry<Item>> ORE_CHUNKS = new HashMap<>(MettleAPI.metalRegistry.entriesCount());
    static {
        MettleAPI.metalRegistry.forEach((id, metal) -> {
            if (!id.getNamespace().equals("minecraft"))
            {
                ItemEntry<Item> oreChunk = REGISTRATE.get()
                        .item("raw_" + id.getPath(), Item::new)
                        .register();
                ORE_CHUNKS.put(id, oreChunk);
            }
        });
    }

    public static final RegistryEntry<Item> METAL_WORKPIECE = REGISTRATE.get()
            .object("metal_workpiece")
            .simple(Item.class, MetalWorkpiece::new);

    public static void init() {}

    private static void registerSimpleItem(String name)
    {
        //REGISTER.register(name, () -> new Item(new Item.Properties().tab(Mettle.CREATIVE_TAB)));
    }
}
