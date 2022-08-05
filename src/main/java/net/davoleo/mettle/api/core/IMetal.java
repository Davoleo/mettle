package net.davoleo.mettle.api.core;

import net.minecraft.resources.ResourceLocation;

public interface IMetal {

    ResourceLocation getId();

    String getName();

    int getColor();


    //Metal Properties

    int getMeltingTemperature();

    float getMalleability();

    float getDensity();

    float getTensileStrength();

    float getHardness();

}
