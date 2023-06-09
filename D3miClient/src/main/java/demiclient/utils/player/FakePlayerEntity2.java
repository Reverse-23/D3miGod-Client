package demiclient.utils.player;

import java.util.UUID;


import com.mojang.authlib.GameProfile;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;

public class FakePlayerEntity2 extends AbstractClientPlayerEntity {

    public FakePlayerEntity2(ClientWorld world, GameProfile gameProfile) {
        super(world, gameProfile);
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public Identifier getSkinTexture() {
        if (hasSkinTexture())
            return super.getSkinTexture();
        else
            return null ; //MCAPIHelper.INSTANCE.getPlayerSkin(MinecraftClient.getInstance().getSession().getProfile() == null ? this.uuid : MinecraftClient.getInstance().getSession().getProfile().getId());
    }
}