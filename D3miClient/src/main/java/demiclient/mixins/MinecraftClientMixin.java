package demiclient.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import demiclient.Client;
import net.minecraft.client.MinecraftClient;


@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(method = "tick", at = @At("HEAD"), cancellable = true)
	public void OnTick(CallbackInfo ci) {
		Client.INSTANCE.onTick();
	}

}
