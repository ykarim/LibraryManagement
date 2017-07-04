package net.packet.model.user;

import model.user.LibAdmin;
import net.packet.Packet;
import net.packet.model.ModelPacketType;

/**
 * Packet sent to server to specify LibAdmin CUD (no READ) operation to be performed
 */
public class LibAdminPacket extends Packet {

    private ModelPacketType packetType;
    private LibAdmin libAdmin;

    public LibAdminPacket(ModelPacketType packetType, LibAdmin libAdmin) {
        this.packetType = packetType;
        this.libAdmin = libAdmin;
    }

    public ModelPacketType getPacketType() {
        return packetType;
    }

    public LibAdmin getLibAdmin() {
        return libAdmin;
    }
}
