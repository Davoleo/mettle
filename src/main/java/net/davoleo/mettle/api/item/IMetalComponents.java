package net.davoleo.mettle.api.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

/**
 * If methods' implementation return null,
 * items and blocks will be created by Mettle,
 * otherwise the mod's features will be used
 */
public interface IMetalComponents {

    @Nullable
    Block getBlock();

    @Nullable
    Item getIngot();

    @Nullable
    Item getNugget();

    @Nullable
    Item getGear();

    @Nullable
    Item getRod();

    @Nullable
    Item getPlate();

}
