package net.packet.book;

import model.item.LibraryBook;
import net.packet.Packet;

import java.io.Serializable;

public class LibraryBookPacket extends Packet implements Serializable {

    private PacketType packetType;
    private LibraryBook book;
    public LibraryBookPacket(PacketType packetType, LibraryBook book) {
        this.packetType = packetType;
        this.book = book;
    }

    public PacketType getPacketType() {
        return packetType;
    }

    public LibraryBook getBook() {
        return book;
    }

    public enum PacketType {
        INVALID(-1), CREATE(0), UPDATE_LIBBOOK(2), DELETE(3);

        private int type;

        PacketType(int type) {
            this.type = type;
        }

        public int getTypeId() {
            return type;
        }
    }
}
