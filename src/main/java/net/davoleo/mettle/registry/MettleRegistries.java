package net.davoleo.mettle.registry;

import net.davoleo.mettle.Mettle;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MettleRegistries {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, Mettle.MODID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Mettle.MODID);
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Mettle.MODID);
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Mettle.MODID);

    public static void registerOnBus(IEventBus bus) {
        BLOCKS.register(bus);
        ITEMS.register(bus);
        BLOCK_ENTITY_TYPES.register(bus);
    }

    public void registerBlock(String name, Supplier<? extends Block> block) {
        BLOCKS.register(name, block);
    }

    public void registerItem(String name, Supplier<? extends Item> item) {
        ITEMS.register(name, item);
    }

    public <T extends BlockEntity> BlockEntityType<T> newBlockEntityType(IBlockEntitySupplier<T> be, Block... validBlocks) {
        return BlockEntityType.Builder.of(be::create, validBlocks).build(null);
    }

    public <T extends BlockEntity> void registerBlockEntity(String name, Supplier<BlockEntityType<T>> blockEntityType) {
        BLOCK_ENTITY_TYPES.register(name, blockEntityType);
    }

}
