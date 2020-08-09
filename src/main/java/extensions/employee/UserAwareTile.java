package extensions.employee;

import gearth.extensions.parsers.HEntity;
import gearth.extensions.parsers.HPoint;

public class UserAwareTile implements UserAwarePoint {
    public HEntity occupant = null;
    public HPoint point     = null;

    /**
     * @param point HPoint
     */
    public UserAwareTile(HPoint point) {
        this.point = point;
    }
}
