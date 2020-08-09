package extensions.employee;

import gearth.extensions.Extension;
import gearth.extensions.ExtensionInfo;
import gearth.extensions.extra.harble.ChatConsole;
import gearth.extensions.extra.harble.HashSupport;
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

    protected void initExtension() {
        hashSupport = new HashSupport(this);
        chatConsole = new ChatConsole(hashSupport, this, "Employee Extension initialized");
        RoomUserStatusHandler roomUserStatusHandler = new RoomUserStatusHandler();
        RoomUserList roomUserList = new RoomUserList();

        hashSupport.intercept(HMessage.Direction.TOCLIENT, "RoomUserStatus", message -> {
            HPacket packet = message.getPacket();
            roomUserStatusHandler.handle(packet, roomUserList);
            roomUserList.printUsers();
        });

        /*
        Room User List
         */
        hashSupport.intercept(HMessage.Direction.TOCLIENT, "RoomUsers", roomUserList::onRoomUsers);
        hashSupport.intercept(HMessage.Direction.TOCLIENT, "RoomUserRemove", roomUserList::onRoomUserRemove);
        hashSupport.intercept(HMessage.Direction.TOSERVER, "RequestRoomLoad", roomUserList::onRequestRoomLoad);
    }

}
