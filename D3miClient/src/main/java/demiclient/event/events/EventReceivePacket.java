package demiclient.event.events;

import demiclient.event.Event;
import net.minecraft.network.packet.Packet;



public class EventReceivePacket extends Event {

	private Packet<?> packet;
	
	public EventReceivePacket(Packet<?> packet) {
		this.packet = packet;
	}
	
	public Packet<?> getPacket() {
		return packet;
	}
}
