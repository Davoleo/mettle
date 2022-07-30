package net.davoleo.mettle.api.core;

import net.minecraftforge.registries.IForgeRegistryEntry;

public interface IMetal extends IForgeRegistryEntry<IMetal> {

    int getColor();


    //Metal Properties

    int getMeltingTemperature();

    float getMalleability();

    float getDensity();

    float getTensileStrength();

    float getHardness();

}
