package net.packet.model.book;

import model.item.book.LibraryBook;
import net.packet.Packet;
import net.packet.model.ModelPacketType;

import java.io.Serializable;

public class LibraryBookPacket extends Packet implements Serializable {

    private ModelPacketType packetType;
    private LibraryBook book;

    public LibraryBookPacket(ModelPacketType packetType, LibraryBook book) {
        this.packetType = packetType;
        this.book = book;
    }

    public ModelPacketType getPacketType() {
        return packetType;
    }

    public LibraryBook getBook() {
        return book;
    }
}
