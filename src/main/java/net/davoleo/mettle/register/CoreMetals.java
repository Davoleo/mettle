package net.davoleo.mettle.register;

import net.davoleo.mettle.Mettle;
import net.davoleo.mettle.api.core.IMetal;
import net.davoleo.mettle.api.core.SimpleMetal;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

public class CoreMetals {

    public static final DeferredRegister<IMetal> REGISTER = DeferredRegister.create(new ResourceLocation(Mettle.MODID, "metal_registry"), Mettle.MODID);

    static
    {
        REGISTER.makeRegistry(IMetal.class, RegistryBuilder::new);
    }

    public static void init() {
        REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
        Vanilla.init();
    }

    public static final class Vanilla {

        public static final RegistryObject<SimpleMetal> IRON = REGISTER.register("iron", () -> new SimpleMetal(
                0xD8D8D8, 1830,
                -1F, //TODO NYI
                7.9F, -1F, //TODO NYI
                4.0F
        ));

        public static final RegistryObject<SimpleMetal> GOLD = REGISTER.register("gold", () -> new SimpleMetal(
                0xFAD64A, 1360,
                -1F, //TODO NYI
                19.3F, -1F, //TODO NYI
                2.5F
        ));

        public static final RegistryObject<SimpleMetal> COPPER = REGISTER.register("copper", () -> new SimpleMetal(
                0xE77C56, 1380,
                -1F, //TODO NYI
                8.0F, -1F, //TODO NYI
                3.0F
        ));

        public static void init() {}
    }
    public static final RegistryObject<SimpleMetal> TIN = REGISTER.register("tin", () -> new SimpleMetal(
            0x00FFFF, //TODO NYI
            530,
            -1F, //TODO NYI
            7.3F, -1F, //TODO NYI
            1.5F
    ));

    public static final RegistryObject<SimpleMetal> ALUMINIUM = REGISTER.register("aluminium", () -> new SimpleMetal(
            0x00FFFF, //TODO NYI
            960,
            -1F, //TODO NYI
            2.7F, -1F, //TODO NYI
            2.75F
    ));

}
