package extensions.employee;

import gearth.extensions.Extension;
import gearth.extensions.ExtensionInfo;
import gearth.extensions.extra.harble.ChatConsole;
import gearth.extensions.extra.harble.HashSupport;
import gearth.extensions.parsers.HEntity;
import gearth.protocol.HMessage;
import gearth.protocol.HPacket;

@ExtensionInfo(
        Title = "Employee",
        Description = "get those coins",
        Version = "1.0",
        Author = "DominikDE & gurkentier"
)

public class Employee extends Extension {

    public static void main(String[] args) {
        new Employee(args).run();
    }
    public Employee(String[] args) {
        super(args);
    }

    public HashSupport hashSupport = null;
    public ChatConsole chatConsole = null;

    @Override
    protected void initExtension() {
        hashSupport = new HashSupport(this);
        chatConsole = new ChatConsole(hashSupport, this, "Employee Extension initialized");
        RoomUserStatusHandler roomUserStatusHandler = new RoomUserStatusHandler();
        RoomUserList roomUserList = new RoomUserList();
        HelpDeskList helpDeskList = new HelpDeskList();

        hashSupport.intercept(HMessage.Direction.TOCLIENT, "RoomUserStatus", message -> {
            HPacket packet = message.getPacket();
            roomUserStatusHandler.handle(packet, roomUserList, helpDeskList);
        });

        hashSupport.intercept(HMessage.Direction.TOCLIENT, "RoomUserRemove", message -> {
            HPacket packet = message.getPacket();
            String userIdx = packet.readString();
            HEntity entity = roomUserList.getEntityByIndex(Integer.parseInt(userIdx));
            helpDeskList.clearOccupancesForEntity(entity);
        });

        /*
        Room User List
         */
        hashSupport.intercept(HMessage.Direction.TOCLIENT, "RoomUsers", roomUserList::onRoomUsers);
        hashSupport.intercept(HMessage.Direction.TOCLIENT, "RoomUserRemove", roomUserList::onRoomUserRemove);
        hashSupport.intercept(HMessage.Direction.TOSERVER, "RequestRoomLoad", message -> {
            roomUserList.onRequestRoomLoad(message);
            helpDeskList.clear();

        });
    }

}
