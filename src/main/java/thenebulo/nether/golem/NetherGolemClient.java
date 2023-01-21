package thenebulo.nether.golem;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import thenebulo.nether.golem.particle.*;
import thenebulo.nether.golem.particle.custom.SummoningStoneParticle;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

@Environment(EnvType.CLIENT)
public class NetherGolemClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.SUMMONING_STONE_PARTICLE, SummoningStoneParticle.Factory::new);
    }

}