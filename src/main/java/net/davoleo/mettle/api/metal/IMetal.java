package net.davoleo.mettle.api.metal;

import net.minecraft.resources.ResourceLocation;

public interface IMetal {

    ResourceLocation getId();

    String getName();

    int getColor();

    MetalProperties getProperties();

    MetalComponents getComponents();

}
