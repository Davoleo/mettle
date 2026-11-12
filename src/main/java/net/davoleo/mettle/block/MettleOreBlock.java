package net.davoleo.mettle.block;

import net.davoleo.mettle.Mettle;
import net.davoleo.mettle.api.block.OreVariant;
import net.davoleo.mettle.api.metal.IMetal;
import net.davoleo.mettle.tag.ITagMember;
import net.davoleo.mettle.util.PropertiesStore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;

import java.util.List;

/**
 * MOreBlock!1!11!!!! -PierKnight
 */
public class MettleOreBlock extends DropExperienceBlock implements ITagMember<Block> {

    private final IMetal metal;
    private final OreVariant variant;
    private final List<TagKey<Block>> tags;

    public MettleOreBlock(IMetal metal, OreVariant variant)
    {
        // TODO: 30/08/2022 Customize
        super(UniformInt.of(0, 2), PropertiesStore.oreProperties(metal));
        this.metal = metal;
        this.variant = variant;
        this.tags = List.of(variant.getTool().getMineableTag());
    }

    @Override
    public List<TagKey<Block>> getTags() {
        return tags;
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return ResourceLocation.fromNamespaceAndPath(Mettle.MODID, metal.name() + "_" + variant.toString() + "_ore");
    }
}
