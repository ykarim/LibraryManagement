package model.user;

import model.item.book.Book;
import model.item.book.LibraryBook;

import java.util.ArrayList;

public class NetUser {

    private String fname, lname;
    private int age, balance;
    private long cardNumber;
    private long id;
    private ArrayList<LibraryBook> checkouts = new ArrayList<LibraryBook>();
    private ArrayList<Book> reserves = new ArrayList<Book>();

    public NetUser(LibUser user) {
        this.fname = user.getFname();
        this.lname = user.getLname();
        this.age = user.getAge();
        this.balance = user.getBalance();
        this.cardNumber = user.getCardNumber();
        this.id = user.getId();
        this.checkouts = user.getCheckouts();
        this.reserves = user.getReserves();
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getAge() {
        return age;
    }

    public int getBalance() {
        return balance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public long getId() {
        return id;
    }

    public ArrayList<LibraryBook> getCheckouts() {
        return checkouts;
    }

    public ArrayList<Book> getReserves() {
        return reserves;
    }
}
