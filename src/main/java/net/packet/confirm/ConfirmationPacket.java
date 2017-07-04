package net.packet.confirm;

import net.packet.Packet;

import java.util.List;

/**
 * Sent over to client to confirm a CRUD operation or any other operation
 * <p>
 * Contains:
 * - boolean representing the success of the operation
 * - List<Object> of any extraneous data to send back to client
 */
public class ConfirmationPacket extends Packet {

    private boolean confirmed; //Represents success of operation performed
    private List<Object> confirmationData; //Holds any other data required to be sent over

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
