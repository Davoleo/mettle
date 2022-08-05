package net.davoleo.mettle.api;

import net.davoleo.mettle.api.registry.AbstractRegistry;
import net.davoleo.mettle.api.core.IMetal;
import net.davoleo.mettle.api.registry.ComponentsRegistry;
import net.davoleo.mettle.api.registry.MetalRegistry;

public class MettleAPI {

    public static final String MODID = "mettle";

    public static final MetalRegistry metalRegistry = MetalRegistry.INSTANCE;
    public static final ComponentsRegistry componentsRegistry = ComponentsRegistry.INSTANCE;

}
