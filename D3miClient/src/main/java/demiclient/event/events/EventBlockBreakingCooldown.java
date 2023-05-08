package demiclient.event.events;

import demiclient.event.Event;

public class EventBlockBreakingCooldown extends Event {
    private int cooldown;

    public EventBlockBreakingCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
}
