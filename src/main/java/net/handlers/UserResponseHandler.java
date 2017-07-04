package net.handlers;

import model.user.LibUser;
import model.user.NetUser;
import model.user.User;
import net.packet.Packet;
import net.packet.auth.LoginResponsePacket;
import net.packet.confirm.ConfirmationPacket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Communicates results of User CRUD operations back to client
 */
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

    /**
     * Sends ConfirmationPacket with confirmation of operation
     *
     * @param confirmation
     */
    public void sendData(boolean confirmation) {
        sendData(new ConfirmationPacket(confirmation, null));
    }

    /**
     * Sends specific user in LoginResponsePacket obj as a reply to LoginPacket
     *
     * @param user
     */
    public void sendData(User user) {
        if (user instanceof LibUser) {
            sendData(new LoginResponsePacket(user));
        }
    }

    /**
     * Sends ConfirmationPacket with users to send over
     * @param usersToSend
     */
    public void sendData(List<NetUser> usersToSend) {
        if (usersToSend.size() > 0) {
            ArrayList<Object> objUsersToSend = new ArrayList<>();
            objUsersToSend.addAll(usersToSend);
            sendData(new ConfirmationPacket(true, objUsersToSend));
        } else {
            sendData(new ConfirmationPacket(false, null));
        }
    }
}
