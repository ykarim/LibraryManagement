package net.packet.auth;

import net.packet.Packet;

public class LoginPacket extends Packet {

    private String username, password;

    public LoginPacket(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
