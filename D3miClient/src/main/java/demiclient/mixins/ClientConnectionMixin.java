package demiclient.mixins;

import io.netty.channel.ChannelHandlerContext;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import demiclient.event.events.EventReceivePacket;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {


    @Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
    public void receive(ChannelHandlerContext channelHandlerContext, Packet<?> packet, CallbackInfo ci) {
        EventReceivePacket event = new EventReceivePacket(packet);
        event.call();
        if(event.isCancelled()) ci.cancel();
    }
}