package net.davoleo.mettle.api.metal;

import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;

public class MetalRatio {

    private final Pair<String, Float> metal1;
    private final Pair<String, Float> metal2;
    @Nullable
    private final Pair<String, Float> metal3;

    public MetalRatio(String metal1, float ratio1, String metal2, float ratio2)
    {
        this(metal1, ratio1, metal2, ratio2, null, 0);
    }

    public MetalRatio(String metal1, float ratio1, String metal2, float ratio2, String metal3, float ratio3)
    {
        this.metal1 = Pair.of(metal1, ratio1);
        this.metal2 = Pair.of(metal2, ratio2);
        this.metal3 = metal3 == null ? null : Pair.of(metal3, ratio3);

        float total = ratio1 + ratio2 + ratio3;
        assert total == 1;
    }

    public float getRatio(String metalName) {
        if (metalName.equals(metal1.getLeft()))
            return metal1.getRight();
        else if (metalName.equals(metal2.getLeft()))
            return metal2.getRight();
        else if (metalName.equals(metal3.getLeft()))
            return metal3.getRight();
        else
            return 0;
    }

}
