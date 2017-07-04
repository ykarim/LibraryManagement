package net.handlers;

import dao.UserDAO;
import model.user.LibUser;
import model.user.NetUser;
import model.user.User;
import net.packet.auth.LoginPacket;
import net.packet.model.user.LibAdminPacket;
import net.packet.model.user.LibUserPacket;
import net.packet.requests.RequestNetUserPacket;

import java.util.ArrayList;
import java.util.List;

/**
 * Process CRUD operations for User objects
 */
public class LibraryUserHandler {

    private UserDAO userDAO;

    public LibraryUserHandler() {
        userDAO = new UserDAO();
    }

    /**
     * Reads information from LibUserPacket to process operation requested
     *
     * @param packet
     * @return boolean representing success of operation
     */
    public boolean parseLibUserPacket(LibUserPacket packet) {
        switch (packet.getPacketType()) {
            case INVALID:
                return false;
            case CREATE:
                return userDAO.createUser(packet.getUser());
            case UPDATE:
                return userDAO.updateUser(packet.getUser());
            case DELETE:
                return userDAO.deleteUser(packet.getUser());
        }
        return false;
    }

    /**
     * Reads information from LibAdminPacket to process operation requested
     *
     * @param packet
     * @return boolean representing success of operation
     */
    public boolean parseLibAdminPacket(LibAdminPacket packet) {
        switch (packet.getPacketType()) {
            case INVALID:
                return false;
            case CREATE:
                return userDAO.createUser(packet.getLibAdmin());
            case UPDATE:
                return userDAO.updateUser(packet.getLibAdmin());
            case DELETE:
                return userDAO.deleteUser(packet.getLibAdmin());
        }
        return false;
    }

    /**
     * Handles get request for specific user(s) by sending over user(s) requested as NetUser objects
     *
     * @param packet
     * @return List of LibUsers as NetUser objects requested
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
                userToReturn.add(new NetUser((LibUser) userDAO.getUserWithId(Long.parseLong(packet.getPropValue().toString()))));
                return userToReturn;
        }
        return null;
    }

    /**
     * Returns User object if user information in LoginPacket is valid
     * If information not valid, null User obj is sent
     * Handles both LibUser and LibAdmin objects
     *
     * @param packet
     * @return User object of authorized user
     */
    public User parseLoginPacket(LoginPacket packet) {
        return userDAO.loginUser(packet.getUsername(), packet.getPassword());
    }
}
