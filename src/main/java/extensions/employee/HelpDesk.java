package extensions.employee;

import gearth.extensions.parsers.HPoint;

public class HelpDesk implements UserAwarePointsPair {
    public boolean occupied = false;
    public UserAwarePoint owner = null;
    public UserAwarePoint tenant = null;
}
