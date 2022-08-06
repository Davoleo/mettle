package net.davoleo.mettle.api.metal;

import net.minecraft.resources.ResourceLocation;

public class SimpleMetal implements IMetal {

    private ResourceLocation id;
    private String name;

    private int color;

    private MetalProperties properties;

    private IMetalComponents components;

    private SimpleMetal(ResourceLocation id, String name, int color, MetalProperties properties, IMetalComponents components)
    {
        this.id = id;
        this.name = name;
        this.color = color;
        this.properties = properties;
        this.components = components;
    }

    @Override
    public ResourceLocation getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
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
    public IMetalComponents getComponents()
    {
        return components;
    }
}
