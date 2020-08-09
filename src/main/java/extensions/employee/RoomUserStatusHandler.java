package extensions.employee;

import gearth.extensions.parsers.HEntity;
import gearth.extensions.parsers.HPoint;
import gearth.protocol.HPacket;

public class RoomUserStatusHandler {

    public void handle(HPacket packet,RoomUserList roomUserList) {
        packet.readInteger();
        int localUserId = packet.readInteger();
        System.out.println("user: " + this.resolveUser(localUserId, roomUserList).getName());
        HPoint tile = new HPoint(packet.readInteger(), packet.readInteger());
        System.out.println("X " + tile.getX() + " - Y " + tile.getY());
        packet.readString();
        packet.readInteger();
        packet.readInteger();
        String action = packet.readString();
        System.out.println(action);
    }

    public HEntity resolveUser(int idx, RoomUserList roomUserList) {
        return roomUserList.getEntityByIndex(idx);
    }
}

/**
 [RoomUserStatus]
 Incoming[2635] <- [0][0][0]7[10]K[0][0][0][1][0][0][0][0][0][0][0][9][0][0][0][9][0][3]0.0[0][0][0][4][0][0][0][4][0][22]/flatctrl 4/sit 1.0 0/
 {l}{u:2635}{i:1}{i:0}{i:9}{i:9}{s:"0.0"}{i:4}{i:4}{s:"/flatctrl 4/sit 1.0 0/"}
 --------------------
 [RoomUserStatus]
 Incoming[2635] <- [0][0][0]9[10]K[0][0][0][1][0][0][0][0][0][0][0][9][0][0][0][9][0][3]0.0[0][0][0][0][0][0][0][0][0][24]/flatctrl 4/mv 9,8,0.0//
 {l}{u:2635}{i:1}{i:0}{i:9}{i:9}{s:"0.0"}{i:0}{i:0}{s:"/flatctrl 4/mv 9,8,0.0//"}

 */
