package extensions.employee;

import gearth.extensions.parsers.HPoint;

public class HelpDesk implements UserAwarePointsPair {
    public boolean occupied = false;
    public UserAwarePoint userAwarePoint = null;
    public HPoint point = null;
}
