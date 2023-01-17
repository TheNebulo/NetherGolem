package thenebulo.nether.golem.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
//import net.minecraft.client.render.DimensionEffects.Nether;
import thenebulo.nether.golem.NetherGolem;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		NetherGolem.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
