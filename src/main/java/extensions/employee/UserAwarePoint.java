package extensions.employee;

import gearth.extensions.parsers.HEntity;
import gearth.extensions.parsers.HPoint;

public interface UserAwarePoint {
    public HEntity occupant = null;
    public HPoint point     = null;
}
