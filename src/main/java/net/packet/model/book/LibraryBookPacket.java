package net.packet.model.book;

import model.item.book.LibraryBook;
import net.packet.Packet;
import net.packet.model.ModelPacketType;

public class LibraryBookPacket extends Packet {

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
