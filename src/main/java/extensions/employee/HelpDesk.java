package extensions.employee;

import gearth.extensions.parsers.HPoint;

public class HelpDesk implements UserAwarePointsPair {
    public UserAwareTile owner  = null;
    public UserAwareTile tenant = null;
    public String type          = "unknown";

    public HelpDesk(HPoint owner, HPoint tenant, String type) {
        this.owner  = new UserAwareTile(owner);
        this.tenant = new UserAwareTile(tenant);
        this.type   = type;
    }
}
