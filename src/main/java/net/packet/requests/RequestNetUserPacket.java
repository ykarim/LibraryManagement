package net.packet.requests;

import net.packet.Packet;

public class RequestNetUserPacket extends Packet {

    private boolean singleUser;
    private UserProp userProp;
    private Object propValue;

    public RequestNetUserPacket(boolean singleUser, UserProp userProp, Object propValue) {
        this.singleUser = singleUser;
        this.userProp = userProp;
        this.propValue = propValue;
    }

    public UserProp getUserProp() {
        return userProp;
    }

    public Object getPropValue() {
        return propValue;
    }

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
