package net.handlers;

import model.user.NetUser;
import net.packet.Packet;
import net.packet.confirm.ConfirmationPacket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserResponseHandler {

    private ObjectOutputStream outputStream;

    public UserResponseHandler(OutputStream outputStream) {
        try {
            this.outputStream = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Replies to client packet by sending Packet obj to client via ObjectOutputStream
     * Use case example: send back confirmation if user exists
     *
     * @param packetToSend
     */
    private void sendData(Packet packetToSend) {
        try {
            outputStream.writeObject(packetToSend);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData(List<NetUser> usersToSend) {
        if (usersToSend.size() > 0) {
            ArrayList<Object> objUsersToSend = new ArrayList<>();
            for (NetUser user : usersToSend) {
                objUsersToSend.add(user);
            }
            sendData(new ConfirmationPacket(true, objUsersToSend));
        } else {
            sendData(new ConfirmationPacket(false, null));
        }
    }
}
