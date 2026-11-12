package net.davoleo.mettle;

import com.mojang.logging.LogUtils;
import net.davoleo.mettle.init.MettlePackFinder;
import net.davoleo.mettle.init.ModRegistry;
import net.davoleo.mettle.registry.IMettleRegistry;
import net.davoleo.mettle.registry.MettleRegistries;
import net.davoleo.mettle.render.IBlockFluidRendering;
import net.davoleo.mettle.util.Utilities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

import java.util.ServiceLoader;
import java.util.function.Supplier;

@Mod(Mettle.MODID)
public class Mettle {

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final String MODID = "mettle";
    public static final String MODNAME = MODID;
    public static final String MODVERSION = ModList.get().getModFileById(Mettle.MODID).versionString();

    //Services
    public final static IMettleRegistry REGISTRY = ServiceLoader.load(IMettleRegistry.class).findFirst().orElseThrow();
    public final static Utilities UTILS = ServiceLoader.load(Utilities.class).findFirst().orElseThrow();
    public final static IBlockFluidRendering BLOCK_FLUID_RENDERING = ServiceLoader.load(IBlockFluidRendering.class).findFirst().orElseThrow();

    public static final Supplier<CreativeModeTab> CREATIVE_TAB = MettleRegistries.CREATIVE_TABS.register(Mettle.MODNAME,
            () -> CreativeModeTab.builder()
                    .title(Component.literal("Mettle"))
                    .icon(() -> new ItemStack(Items.COPPER_INGOT))
                    .build()
    );

    public Mettle(ModContainer container)
    {
        IEventBus modBus = ModLoadingContext.get().getActiveContainer().getEventBus();

        if (modBus == null) {
            LOGGER.error("mettle mod bus doesn't exist! WUT?");
            throw new RuntimeException("mettle bus doesn't come pick me up help!");
        }

        // Register the setup method for modloading
        modBus.addListener(this::setup);

        MettlePackFinder.doTheStuff();
        ModRegistry.init();
        MettleRegistries.registerOnBus(modBus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        Mettle.LOGGER.info("HELLO FROM {}", Mettle.MODNAME);
        ModRegistry.METAL_COMPONENTS.values().forEach(
                components -> components.ores().values().forEach(
                        ore -> BLOCK_FLUID_RENDERING.setRenderType(ore.get(), RenderType.cutout())
                )
        );
    }

}
