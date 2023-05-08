package demiclient.event.events;

import net.minecraft.particle.ParticleEffect;

import demiclient.event.Event;

public class ParticleEvent extends Event {
    public ParticleEffect particle;

    public ParticleEvent(ParticleEffect particle) {
        this.setCancelled(false);
        this.particle = particle;
    }
}