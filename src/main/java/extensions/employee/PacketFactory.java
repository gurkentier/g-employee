package extensions.employee;

import gearth.extensions.parsers.HPoint;
import gearth.protocol.HPacket;

public class PacketFactory {

    public static HPacket buildWalkPacketFromCoords(int x, int y) {
        int HEADER = 2998;
        return buildWalkPacketFromPoint(new HPoint(x, y));
    }

    public static HPacket buildWalkPacketFromPoint(HPoint point) {
        int HEADER = 2998;
        return new HPacket("{l}{u:2990}{i:"+ point.getX() +"}{i:" + point.getY() +"}");
    }
}
