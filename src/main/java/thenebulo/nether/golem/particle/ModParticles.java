package thenebulo.nether.golem.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.*;

public class ModParticles {
    public static final DefaultParticleType SUMMONING_STONE_PARTICLE = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier("nethergolem", "summoning_stone_particle"),
        SUMMONING_STONE_PARTICLE);
    }
}