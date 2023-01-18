package thenebulo.nether.golem;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;

@Environment(EnvType.CLIENT)
public class NetherGolemClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        /* Registers our particle client-side.
         * First argument is our particle's instance, created previously on ExampleMod.
         * Second argument is the particle's factory. The factory controls how the particle behaves.
         * In this example, we'll use FlameParticle's Factory. */
        ParticleFactoryRegistry.getInstance().register(NetherGolem.GREEN_FLAME, FlameParticle.Factory::new);

    }

}