package net.davoleo.mettle.world;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.bus.api.SubscribeEvent;

import java.util.List;

@Deprecated
public class MettleOreGeneration {

    @SubscribeEvent
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> features = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
        features.addAll(MettleOrePlacements.ALL);
    }

}
