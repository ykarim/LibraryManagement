package dao;

import model.user.LibAdmin;
import model.user.LibUser;
import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static List<User> users = new ArrayList<User>();

    public List<User> getUsers() {
        return users;
    }

    public List<LibUser> getLibUsersWithFName(String fName) {
        List<LibUser> usersWithFName = new ArrayList<>();
        for (User user : users) {
            if (user instanceof LibUser) {
                if (user.getFname().contains(fName)) {
                    usersWithFName.add((LibUser) user);
                }
            }
        }

        return (usersWithFName.size() > 0) ? usersWithFName : null;
    }

    public List<LibAdmin> getLibAdminsWithFName(String fName) {
        List<LibAdmin> adminsWithFName = new ArrayList<>();
        for (User user : users) {
            if (user instanceof LibAdmin) {
                if (user.getFname().contains(fName)) {
                    adminsWithFName.add((LibAdmin) user);
                }
            }
        }

        return (adminsWithFName.size() > 0) ? adminsWithFName : null;
    }

    public List<LibUser> getLibUsersWithLName(String lName) {
        List<LibUser> usersWithLName = new ArrayList<>();
        for (User user : users) {
            if (user instanceof LibUser) {
                if (user.getLname().contains(lName)) {
                    usersWithLName.add((LibUser) user);
                }
            }
        }

        return (usersWithLName.size() > 0) ? usersWithLName : null;
    }

    public List<LibAdmin> getLibAdminsWithLName(String lName) {
        List<LibAdmin> usersWithLName = new ArrayList<>();
        for (User user : users) {
            if (user instanceof LibAdmin) {
                if (user.getLname().contains(lName)) {
                    usersWithLName.add((LibAdmin) user);
                }
            }
        }

        return (usersWithLName.size() > 0) ? usersWithLName : null;
    }

    public List<LibUser> getLibUsersWithCardNum(String cardNum) {
        List<LibUser> usersWithCardNum = new ArrayList<>();
        for (User user : users) {
            if (user instanceof LibUser) {
                if (Long.toString(((LibUser) user).getCardNumber()).contains(cardNum)) {
                    usersWithCardNum.add((LibUser) user);
                }
            }
        }

        return (usersWithCardNum.size() > 0) ? usersWithCardNum : null;
    }

    public User getUserWithId(long iD) {
        if (users.size() > 0) {
            for (User user : users) {
                if (user.getId() == iD) {
                    return user;
                }
            }
        }
        return null;
    }

    public boolean createUser(User user) {
        ArrayList<Long> iD = new ArrayList<Long>();
        for (User currentUser : users) {
            iD.add(currentUser.getId());
        }

        return !iD.contains(user.getId()) && users.add(user);
    }

    public boolean updateUser(User updatedUser) {
        if (users.size() > 0) {
            for (User user : users) {
                if (updatedUser.getId() == user.getId()) {
                    users.set(users.indexOf(user), updatedUser);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteUser(User user) {
        if (users.size() > 0) {
            for (User currUser : users) {
                if (currUser.getId() == user.getId()) {
                    return users.remove(currUser);
                }
            }
        }
        return false;
    }
}
