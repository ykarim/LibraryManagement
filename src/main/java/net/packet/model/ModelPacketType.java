package net.packet.model;

/**
 * Holds IDs of CUD operations to be read by server for processing
 */
public enum ModelPacketType {

    INVALID(-1), CREATE(0), UPDATE(2), DELETE(3);

    private int typeId;

    ModelPacketType(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }
}
