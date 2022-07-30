package net.davoleo.mettle.api.core;

import net.minecraftforge.registries.ForgeRegistryEntry;

public final class SimpleMetal extends ForgeRegistryEntry<IMetal> implements IMetal {

    private final int color;


    private final int meltingTemperature;
    private final float malleability;
    private final float density;
    private final float tensileStrength;
    private final float hardness;

    public SimpleMetal(
            int color, int meltingTemperature,
            float malleability, float density, float tensileStrength, float hardness)
    {
        this.color = color;
        this.meltingTemperature = meltingTemperature;
        this.malleability = malleability;
        this.density = density;
        this.tensileStrength = tensileStrength;
        this.hardness = hardness;
    }

    @Override
    public int getColor()
    {
        return color;
    }

    @Override
    public int getMeltingTemperature()
    {
        return meltingTemperature;
    }

    @Override
    public float getMalleability()
    {
        return malleability;
    }

    @Override
    public float getDensity()
    {
        return density;
    }

    @Override
    public float getTensileStrength()
    {
        return tensileStrength;
    }

    @Override
    public float getHardness()
    {
        return hardness;
    }

    public String getMetalName()
    {
        return getRegistryName().getPath();
    }

}
