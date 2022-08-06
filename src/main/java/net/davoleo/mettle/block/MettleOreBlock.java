package net.davoleo.mettle.block;

import net.davoleo.mettle.api.metal.IMetal;
import net.minecraft.world.level.block.OreBlock;

/**
 * MOreBlock!1!11!!!! -PierKnight
 */
public class MettleOreBlock extends OreBlock {

    public MettleOreBlock(Properties props, IMetal metal)
    {
        super(props.strength(metal.getHardness()));
    }
}
