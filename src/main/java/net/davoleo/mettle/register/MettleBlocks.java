package net.davoleo.mettle.register;

import com.google.common.collect.Lists;
import net.davoleo.mettle.Mettle;
import net.davoleo.mettle.block.MettleOreBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Supplier;

public class MettleBlocks {

    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Mettle.MODID);
    public static LinkedList<BlockEntry<? extends Block>> blocks = Lists.newLinkedList();

    public static void init() {
        MettleBlocks.REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
        Ores.init();

        for (BlockEntry<? extends Block> entry : blocks) {
            MettleItems.registerSimpleBlockItem(entry);
        }

    }

    public static final class Ores {

        public static final BlockEntry<Block> TIN_ORE = new BlockEntry<>("tin_ore",
                () -> BlockBehaviour.Properties.of(Material.STONE),
                properties -> new MettleOreBlock(properties, CoreMetals.TIN.get())
        );
        public static final BlockEntry<Block> ALUMINIUM_ORE = new BlockEntry<>("aluminium_ore",
                () -> BlockBehaviour.Properties.of(Material.STONE),
                properties -> new MettleOreBlock(properties, CoreMetals.ALUMINIUM.get())
        );

        public static void init() {}
    }

    /**
     * Inspired from <a href="https://github.com/BluSunrize/ImmersiveEngineering">Immersive Engineering</a>'s IEBlocks$BlockEntry Registration Utility Class
     * @param <T> The related block entry
     */
    public static final class BlockEntry<T extends Block> implements ItemLike, Supplier<T> {

        private final RegistryObject<T> regEntry;
        private final Supplier<BlockBehaviour.Properties> properties;

        public BlockEntry(String name, Supplier<BlockBehaviour.Properties> properties, Function<BlockBehaviour.Properties, T> generator)
        {
            this.regEntry = REGISTER.register(name, () -> generator.apply(properties.get()));
            this.properties = properties;
            blocks.add(this);
        }

        public BlockBehaviour.Properties getProperties()
        {
            return properties.get();
        }

        @Override
        public T get()
        {
            return regEntry.get();
        }

        public ResourceLocation getRegistryId() {
            return regEntry.getId();
        }

        @Nonnull
        @Override
        public Item asItem()
        {
            return get().asItem();
        }
    }

}
