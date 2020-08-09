package extensions.employee;

import gearth.extensions.parsers.HPoint;
import java.util.ArrayList;

public class HelpDeskList {

    private ArrayList<HelpDesk> helpDesks = new ArrayList<>();

    /**
     * @param point HPoint
     * @return HelpDesk
     */
    public HelpDesk getDeskByOwnerPoint(HPoint point) {
        HelpDesk result = null;
        for (HelpDesk pair : helpDesks) {
            HPoint ownerPoint = pair.owner.point;
            assert ownerPoint != null;
            if (ownerPoint.getX() == point.getX() && ownerPoint.getY() == point.getY()) {
                result = pair;
            }
        }

        return result;
    }

    /**
     * @param point HPoint
     * @return HelpDesk
     */
    public HelpDesk getDeskByTenantPoint(HPoint point) {
        HelpDesk result = null;
        for (HelpDesk pair : helpDesks) {
            HPoint tenantPoint = pair.tenant.point;
            assert tenantPoint != null;
            if (tenantPoint.getX() == point.getX() && tenantPoint.getY() == point.getY()) {
                result = pair;
            }
        }

        return result;
    }

}
