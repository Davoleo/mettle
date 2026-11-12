package net.davoleo.mettle.util;

import net.davoleo.mettle.Mettle;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLLoader;

import java.nio.file.Path;

public class Utilities {

    public CreativeModeTab getTab() {
        return Mettle.CREATIVE_TAB.get();
    }

    public Path getResourcesPath() {
        return ModList.get().getModFileById(Mettle.MODID).getFile().getFilePath();
    }

    public boolean isDevEnv() {
        return !FMLLoader.isProduction();
    }

    public Side getPhysicalSide() {
        return FMLEnvironment.dist == Dist.CLIENT ? Side.CLIENT : Side.SERVER;
    }


    public enum Side {
        CLIENT,
        SERVER;

        public boolean isClient() {
            return this == CLIENT;
        }
        public boolean isServer() {
            return this == SERVER;
        }
    }
}
