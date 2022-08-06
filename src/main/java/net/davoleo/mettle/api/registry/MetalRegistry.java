package net.davoleo.mettle.api.registry;

import net.davoleo.mettle.api.metal.IMetal;

public class MetalRegistry extends AbstractRegistry<IMetal> {

    public static final MetalRegistry INSTANCE = new MetalRegistry();

}
