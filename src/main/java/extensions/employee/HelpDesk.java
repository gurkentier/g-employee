package extensions.employee;

import gearth.extensions.parsers.HPoint;

public class HelpDesk implements UserAwarePointsPair {
    public UserAwareTile owner = null;
    public UserAwareTile tenant = null;

    public HelpDesk(HPoint owner, HPoint tenant) {
        this.owner = new UserAwareTile(owner);
        this.tenant = new UserAwareTile(tenant);
    }
}
