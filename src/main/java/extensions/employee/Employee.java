package extensions.employee;

import gearth.extensions.Extension;
import gearth.extensions.ExtensionInfo;
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

    private boolean done = true;

    protected void initExtension() {
        intercept(HMessage.Direction.TOCLIENT, message -> {
            if (!done) {
                HPacket packet = message.getPacket();
                if (packet.length() == 11) {
                    if (packet.readByte(14) == 0 || packet.readByte(14) == 1) {
                        packet.replaceInt(6, 7);
                        packet.replaceInt(10, 7);
                        packet.replaceBoolean(14, true);

                        done = true;
                        writeToConsole("Replaced user permissions");
                    }
                }
            }
        });

        intercept(HMessage.Direction.TOSERVER, 4000, message -> done = false);
    }

//    protected void onStartConnection() {
//        done = false;
//    }
}
