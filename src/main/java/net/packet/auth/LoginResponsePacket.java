package net.packet.auth;

import model.user.User;
import net.packet.Packet;

public class LoginResponsePacket extends Packet {

    private User user;

    public LoginResponsePacket(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
