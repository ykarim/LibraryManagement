package net.handlers;

import dao.UserDAO;
import model.user.LibUser;
import model.user.NetUser;
import net.packet.model.user.LibUserPacket;
import net.packet.requests.RequestNetUserPacket;

import java.util.ArrayList;
import java.util.List;

public class LibraryUserHandler {

    private UserDAO userDAO;

    /**
     * Creates handler to deal process getter requests for users
     */
    public LibraryUserHandler() {
        userDAO = new UserDAO();
    }

    /**
     * @param packet
     */
    public boolean parseLibUserPacket(LibUserPacket packet) {
        switch (packet.getPacketType()) {
            case INVALID:
                return false;
            case CREATE:
                return userDAO.createUser(packet.getUser());
            case UPDATE_LIBBOOK:
                return userDAO.updateUser(packet.getUser());
            case DELETE:
                return userDAO.deleteUser(packet.getUser());
        }
        return false;
    }

    /**
     * @param packet
     * @return
     */
    public List<NetUser> parseNetUserPacket(RequestNetUserPacket packet) {
        ArrayList<NetUser> userToReturn = new ArrayList<>();
        switch (packet.getUserProp()) {
            case FIRST_NAME:
                for (LibUser user : userDAO.getLibUsersWithFName(packet.getPropValue().toString())) {
                    userToReturn.add(new NetUser(user));
                }
                return userToReturn;
            case LAST_NAME:
                for (LibUser user : userDAO.getLibUsersWithLName(packet.getPropValue().toString())) {
                    userToReturn.add(new NetUser(user));
                }
                return userToReturn;
            case ID:
                userToReturn.add(new NetUser((LibUser) userDAO.getUserWithId(Long.valueOf(packet.getPropValue().toString()))));
                return userToReturn;
        }
        return null;
    }
}
