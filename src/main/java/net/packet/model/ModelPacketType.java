package net.packet.model;

public enum ModelPacketType {

    INVALID(-1), CREATE(0), UPDATE_LIBBOOK(2), DELETE(3);

    private int typeId;

    ModelPacketType(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }
}
