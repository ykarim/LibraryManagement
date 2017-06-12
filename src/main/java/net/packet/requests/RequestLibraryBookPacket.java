package net.packet.requests;

import net.packet.Packet;

public class RequestLibraryBookPacket extends Packet {

    private boolean singleBook;
    private BookProp property;
    private Object propertyValue;

    public RequestLibraryBookPacket(boolean singleBook, BookProp property, Object propertyValue) {
        this.singleBook = singleBook;
        this.property = property;
        this.propertyValue = propertyValue;
    }

    public boolean isSingleBook() {
        return singleBook;
    }

    public BookProp getProperty() {
        return property;
    }

    public Object getPropertyValue() {
        return propertyValue;
    }

    public enum BookProp {
        TITLE(0), ISBN(1), ID(2);

        private int bookPropId;

        BookProp(int bookPropId) {
            this.bookPropId = bookPropId;
        }

        public int getBookPropId() {
            return bookPropId;
        }
    }
}
