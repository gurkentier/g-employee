package extensions.employee;

import gearth.extensions.parsers.HPoint;

public class UserAwareTile implements UserAwarePoint {
    public boolean occupied = false;
    public HPoint point = null;
    
    public UserAwareTile(HPoint point) {
        this.point = point;
    }
}
