package net.davoleo.mettle.api.registry;

import net.davoleo.mettle.api.item.IMetalComponents;

public class ComponentsRegistry extends AbstractRegistry<IMetalComponents> {

    public static final ComponentsRegistry INSTANCE = new ComponentsRegistry();
}
