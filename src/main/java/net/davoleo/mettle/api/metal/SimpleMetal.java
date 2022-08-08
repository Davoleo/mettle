package net.davoleo.mettle.api.metal;

import net.minecraft.resources.ResourceLocation;

public class SimpleMetal implements IMetal {

    private String name;

    private int color;

    private MetalProperties properties;

    private MetalComponents components;

    public SimpleMetal(String name, int color, MetalProperties properties, MetalComponents components)
    {
        this.name = name;
        this.color = color;
        this.properties = properties;
        this.components = components;
    }

    @Override
    public ResourceLocation getId()
    {
        return new ResourceLocation("mettle", name);
    }

    @Override
    public String getName()
    {
        return "mettle.metal." + name;
    }

    @Override
    public int getColor()
    {
        return color;
    }

    @Override
    public MetalProperties getProperties()
    {
        return properties;
    }

    @Override
    public MetalComponents getComponents()
    {
        return components;
    }
}
