package net.davoleo.mettle.capability;

import net.davoleo.mettle.api.capability.IMetalMixture;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class MetalMixture implements IMetalMixture {

    public static final Capability<IMetalMixture> MIXTURE = CapabilityManager.get(new CapabilityToken<>() {
        @Override
        public String toString()
        {
            return super.toString();
        }
    });

    public String banane;

    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag tag = new CompoundTag();
        tag.putString("BANANE", "baaa");
        return tag;
    }

    //lm -> ls

    //100% | 90% COPPER | 10% TIN
    //100% | 75% C | 25% T
    @Override
    public void deserializeNBT(CompoundTag nbt)
    {
        banane = nbt.getString("BANANE");
        //nbt.remove("BANANE");
    }
}
