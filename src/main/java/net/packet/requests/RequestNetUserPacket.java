package net.packet.requests;

public class RequestNetUserPacket {

    private boolean singleUser;
    private UserProp userProp;
    private Object propValue;

    public enum UserProp {
        FIRST_NAME(0), LAST_NAME(1), ID(2);

        private int userPropId;

        UserProp(int userPropId) {
            this.userPropId = userPropId;
        }

        public int getUserPropId() {
            return userPropId;
        }
    }
}
