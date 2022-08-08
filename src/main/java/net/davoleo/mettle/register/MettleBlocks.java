package net.davoleo.mettle.register;

import com.google.common.collect.Lists;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.davoleo.mettle.Mettle;
import net.davoleo.mettle.block.MettleOreBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedList;

import static net.davoleo.mettle.Mettle.REGISTRATE;

public class MettleBlocks {

    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Mettle.MODID);
    public static LinkedList<BlockEntry<? extends Block>> blocks = Lists.newLinkedList();

    public static void init() {
        MettleBlocks.REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
        Ores.init();
    }

    public static final class Ores {

        public static final com.tterrag.registrate.util.entry.BlockEntry<MettleOreBlock> TIN_ORE
                 = REGISTRATE.get().object("tin_ore")
                .block(p -> new MettleOreBlock(BlockBehaviour.Properties.of(Material.STONE), CoreMetals.TIN))
                .simpleItem()
                .register();

        public static final com.tterrag.registrate.util.entry.BlockEntry<MettleOreBlock> ALUMINIUM_ORE
                = REGISTRATE.get().object("aluminium_ore")
                .block(p -> new MettleOreBlock(BlockBehaviour.Properties.of(Material.STONE), CoreMetals.ALUMINIUM))
                .simpleItem()
                .register();

        public static void init() {}
    }

}
