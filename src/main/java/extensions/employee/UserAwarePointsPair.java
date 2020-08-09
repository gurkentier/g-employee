package extensions.employee;

import gearth.extensions.parsers.HPoint;

public interface UserAwarePointsPair {
    public UserAwarePoint owner = null;
    public UserAwarePoint tenant = null;
}
