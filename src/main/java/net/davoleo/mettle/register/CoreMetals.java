package net.davoleo.mettle.register;

import net.davoleo.mettle.Mettle;
import net.davoleo.mettle.api.MettleAPI;
import net.davoleo.mettle.api.metal.MetalProperties;
import net.davoleo.mettle.api.metal.SimpleMetal;
import net.minecraft.resources.ResourceLocation;

public class CoreMetals {

    public static void init() {
        Vanilla.init();

        MettleAPI.metalRegistry.register(new ResourceLocation("iron"), Vanilla.IRON);
        MettleAPI.metalRegistry.register(new ResourceLocation("gold"), Vanilla.GOLD);
        MettleAPI.metalRegistry.register(new ResourceLocation("copper"), Vanilla.COPPER);

        MettleAPI.metalRegistry.register(new ResourceLocation(Mettle.MODID, "tin"), TIN);
        MettleAPI.metalRegistry.register(new ResourceLocation(Mettle.MODID, "aluminium"), ALUMINIUM);
    }

    public static final class Vanilla {

        public static final SimpleMetal IRON = new SimpleMetal(
                "iron",
                0xD8D8D8,
                new MetalProperties(1830, 0.43F, 7.9F, 230, 4.0F),
                null
        );

        public static final SimpleMetal GOLD = new SimpleMetal(
                "gold",
                0xFAD64A,
                new MetalProperties(1360, 0.93F, 19.3F, 100, 2.5F),
                null
        );

        public static final SimpleMetal COPPER = new SimpleMetal(
                "copper",
                0xE77C56,
                new MetalProperties(1380, 0.62F, 7.9F, 250, 3.0F),
                null
        );

        public static void init() {}
    }

    public static final SimpleMetal TIN = new SimpleMetal(
            "tin",
            0x00FFFF,
            new MetalProperties(530, 0.69F, 7.3F, 45, 1.5F),
            null
    );

    public static final SimpleMetal ALUMINIUM = new SimpleMetal(
            "aluminium",
            0x00FF00,
            new MetalProperties(960, 0.65F, 2.7F, 150, 2.75F),
            null
    );
}
