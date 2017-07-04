package net.packet.auth;

import model.user.User;
import net.packet.Packet;

/**
 * After authorization by server, regardless of outcome whether successful or not, User object representing successfully
 * signed in user is sent back to client. User object is null if authorization fails and packet is still sent over to
 * client.
 */
public class LoginResponsePacket extends Packet {

    private User user;

    public LoginResponsePacket(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
