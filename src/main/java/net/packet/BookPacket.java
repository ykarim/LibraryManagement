package net.packet;

import java.io.Serializable;

public class BookPacket extends Packet implements Serializable {

    private TYPE type;

    public enum TYPE {
        INVALID(-1), CREATE(0), READ(1), UPDATE(2), DELETE(3);

        private int type;

        TYPE(int type) {
            this.type = type;
        }

        public int getTypeId() {
            return type;
        }
    }

    public TYPE getType() {
        return type;
    }
}
