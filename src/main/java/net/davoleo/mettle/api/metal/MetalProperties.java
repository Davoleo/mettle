package net.davoleo.mettle.api.metal;

public record MetalProperties(int meltingTemperature,
                              float malleability,
                              float density,
                              float tensileStrength,
                              float hardness) {
}
