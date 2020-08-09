package extensions.employee;

import gearth.extensions.parsers.HPoint;
import gearth.protocol.HPacket;

public class RoomUserStatusHandler {
    public HPacket packet = null;

    public RoomUserStatusHandler(HPacket packet) {
        this.packet = packet;
    }

    public void handle() {
        this.packet.readInteger();
        this.packet.readInteger();
        HPoint tile = new HPoint(this.packet.readInteger(), this.packet.readInteger());
        System.out.println("X " + tile.getX() + " - Y " + tile.getY());
        this.packet.readString();
        this.packet.readInteger();
        this.packet.readInteger();
        String action = this.packet.readString();
        System.out.println(action);
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
