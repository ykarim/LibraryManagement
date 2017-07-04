package net.packet.model.book;

import model.item.book.LibraryBook;
import net.packet.Packet;
import net.packet.model.ModelPacketType;

/**
 * Packet sent to server to specify LibraryBook CUD (no READ) operation to be performed
 */
public class LibraryBookPacket extends Packet {

    private ModelPacketType packetType; //Specifies the type of operation to be performed
    private LibraryBook book; //Represents the book for the operation to be executed upon

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
