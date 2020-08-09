package extensions.employee;

import gearth.extensions.parsers.HPoint;
import gearth.protocol.HPacket;

public class PacketFactory {

    public static HPacket buildWalkPacketFromPoint(HPoint point) {
        int HEADER = 2998;
        return new HPacket("{l}{u:"+ HEADER +"}{i:"+ point.getX() +"}{i:" + point.getY() +"}");
    }

    public static HPacket buildWalkPacketFromCoords(int x, int y) {
        return buildWalkPacketFromPoint(new HPoint(x, y));
    }

}
