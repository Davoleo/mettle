package net.davoleo.mettle.block;

import net.davoleo.mettle.api.core.IMetal;
import net.minecraft.world.level.material.Material;

/**
 * MOreBlock!1!11!!!! -PierKnight
 */
public class MettleOreBlock extends net.minecraft.world.level.block.OreBlock {

    public MettleOreBlock(Properties props, IMetal metal)
    {
        super(props.strength(metal.getHardness()));
    }
}
