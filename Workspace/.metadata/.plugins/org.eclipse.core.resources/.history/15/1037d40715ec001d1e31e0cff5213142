package me.pm.dragoncosmetics.mixins;

import me.pm.dragoncosmetics.cosmetics.features.WingFeatureRenderer;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin  extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {

    public PlayerEntityRendererMixin(EntityRenderDispatcher dispatcher, PlayerEntityModel model, float shadowRadius) {
        super(dispatcher, model, shadowRadius);
    }

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/render/entity/EntityRenderDispatcher;Z)V")
    private void addFeatures(EntityRenderDispatcher dispatcher, boolean bl, CallbackInfo ci) {
//        this.addFeature(new HatFeatureRenderer(this));
        this.addFeature(new WingFeatureRenderer(this));
//        this.addFeature(new CapeFeatureRenderer(this));
    }
}