package net.davoleo.mettle.register;

import net.davoleo.mettle.Mettle;
import net.davoleo.mettle.api.core.IMetal;
import net.davoleo.mettle.api.core.SimpleMetal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class MettleItems {

    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Mettle.MODID);

    public static final Map<IMetal, RegistryObject<Item>> ORE_CHUNKS = new HashMap<>();

    public static void init() {
        REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());

        for(RegistryObject<IMetal> metalObj : CoreMetals.REGISTER.getEntries())
        {
            IMetal metal = metalObj.get();
            if (CoreMetals.Vanilla.IRON.get() != metal &&
                    CoreMetals.Vanilla.COPPER.get() != metal &&
                    CoreMetals.Vanilla.GOLD.get() != metal) {
                registerSimpleItem(metalObj.getId().getPath());
            }
        }
    }

    private static void registerSimpleItem(String name)
    {
        REGISTER.register(name, () -> new Item(new Item.Properties().tab(Mettle.CREATIVE_TAB)));
    }

    public static void registerSimpleBlockItem(MettleBlocks.BlockEntry<? extends Block> block) {
        // TODO: 30/07/2022 Maybe add to a cache
        REGISTER.register(
                block.getRegistryId().getPath(),
                () -> new BlockItem(block.get(),
                        new Item.Properties().tab(Mettle.CREATIVE_TAB))
        );
    }
}
