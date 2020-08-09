package extensions.employee;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import gearth.extensions.Extension;
import gearth.extensions.ExtensionInfo;
import gearth.extensions.parsers.HPoint;
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

    protected void initExtension() {
        intercept(HMessage.Direction.TOCLIENT, message -> {
            // this is just a test
            sendToServer(PacketFactory.buildWalkPacketFromCoords(14, 26));
        });
    }

}
