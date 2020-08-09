package extensions.employee;

import java.util.ArrayList;

import gearth.extensions.parsers.HEntity;
import gearth.extensions.parsers.HEntityType;
import gearth.protocol.HMessage;
import gearth.protocol.HPacket;

public class RoomUserList {
    private ArrayList<HEntity> roomUsers = new ArrayList<>();

    public String getUserNameByIndex(int idx) {
        for (HEntity hEntity : roomUsers) {
            if (hEntity.getIndex() == idx) {
                return hEntity.getName();
            }
        }

        return "UserNotFound";
    }

    public HEntity getEntityByIndex(int idx) {
        HEntity result = null;
        for (HEntity hEntity : roomUsers) {
            if (hEntity.getIndex() == idx) {
                result = hEntity;
            }
        }

        return result;
    }

    public void onRequestRoomLoad(HMessage message) {
        roomUsers.clear();
    }

    public void onRoomUserRemove(HMessage message) {
        HPacket msg = message.getPacket();
        String removeUserIdx = msg.readString();
        HEntity hEntity = null;

        ArrayList<HEntity> roomUsers2 = (ArrayList<HEntity>) roomUsers.clone();
        for (HEntity entity : roomUsers2) {
            hEntity = entity;

            if (hEntity.getIndex() == Integer.parseInt(removeUserIdx)) {
                break;
            }
        }

        if (roomUsers.contains(hEntity)) {
            assert hEntity != null;
            System.out.println("Removing User " + hEntity.getName());
            roomUsers.remove(hEntity);
        }
    }

    public void onRoomUsers(HMessage message) {
        HEntity[] users = HEntity.parse(message.getPacket());

        for (HEntity user : users) {
            if (user.getEntityType() == HEntityType.HABBO) {
                System.out.println("(" + user.getIndex() + ") Adding User " + user.getName() + " of entity Type " + user.getEntityType());
                roomUsers.add(user);
            }
        }
    }

    public void printUsers() {
        System.out.println("All Users currently in Room: ");
        for (HEntity hEntity : roomUsers) {
            System.out.println(hEntity.getName());
        }
    }
}