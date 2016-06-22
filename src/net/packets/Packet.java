package net.packets;

import net.LibServer;
import net.LibClient;


public abstract class Packet {

    public static enum PacketTypes {
        INVALID(-1), LOGINUSER(00), DISCONNECT(01), AddBook(02), AddUser(03), LoginInfo(04), BookInfo(05), ReserveItem(06), AddAdmin(07), LoginAdmin(10),Accepted(12), NotAccepted(13),
        AcceptedAdmin(11), EditBook(14), CheckinBook(15), CheckoutBook(16), DeleteAdmin(17), DeleteBook(18), DeleteUser(19), AdminAlreadyExists(20), 
        AdminNotExists(21), BookAlreadyExists(22), BookNotExists(23), UserAlreadyExists(24), UserNotExists(25), BookChange(33);

        private int packetId;

        private PacketTypes(int packetId) {
            this.packetId = packetId;
        }

        public int getId() {
            return packetId;
        }
    }

    public byte packetId;

    public Packet(int packetId) {
        this.packetId = (byte) packetId;
    }

   public abstract void writeData(LibClient client);

   public abstract void writeData(LibServer server);

    public String readData(byte[] data) {
        String message = new String(data).trim();
        return message.substring(2);
    }

    public abstract byte[] getData();

    public static PacketTypes lookupPacket(String packetId) {
        try {
            return lookupPacket(Integer.parseInt(packetId));
        } catch (NumberFormatException e) {
            return PacketTypes.INVALID;
        }
    }

    public static PacketTypes lookupPacket(int id) {
        for (PacketTypes p : PacketTypes.values()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return PacketTypes.INVALID;
    }
}
