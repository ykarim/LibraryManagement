package net.packet.confirm;

import net.packet.Packet;

import java.util.List;

public class ConfirmationPacket extends Packet {

    private boolean confirmed;
    private List<Object> confirmationData;

    public ConfirmationPacket(boolean confirmed, List<Object> confirmationData) {
        this.confirmed = confirmed;
        this.confirmationData = confirmationData;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public List<Object> getConfirmationData() {
        return confirmationData;
    }
}
