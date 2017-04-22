package model.item;

public abstract class Item {

    private String title, creator;
    private long ID;
    private int numAvailable;

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    void setCreator(String creator) {
        this.creator = creator;
    }

    public long getID() {
        return ID;
    }

    void setID(long ID) {
        this.ID = ID;
    }

    public int getNumAvailable() {
        return numAvailable;
    }

    void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

    public abstract long generateID();

    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Item && ((Item) obj).getID() == this.getID());
    }
}
