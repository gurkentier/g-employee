package extensions.employee;

import gearth.extensions.parsers.HEntity;
import gearth.extensions.parsers.HPoint;
import java.util.ArrayList;

public class HelpDeskList {

    private ArrayList<HelpDesk> helpDesks = new ArrayList<>();

    public HelpDeskList() {
        helpDesks.add(new HelpDesk(new HPoint(9, 14), new HPoint(9, 12)));
        helpDesks.add(new HelpDesk(new HPoint(10, 14), new HPoint(10, 12)));
        helpDesks.add(new HelpDesk(new HPoint(11, 14), new HPoint(11, 12)));
        helpDesks.add(new HelpDesk(new HPoint(12, 14), new HPoint(12, 12)));
        helpDesks.add(new HelpDesk(new HPoint(13, 14), new HPoint(13, 12)));
        helpDesks.add(new HelpDesk(new HPoint(14, 14), new HPoint(14, 12)));
        helpDesks.add(new HelpDesk(new HPoint(15, 14), new HPoint(15, 12)));
        helpDesks.add(new HelpDesk(new HPoint(16, 14), new HPoint(16, 12)));
        helpDesks.add(new HelpDesk(new HPoint(17, 14), new HPoint(17, 12)));
    }

    /**
     * @param occupant HEntity
     * @return HelpDesk
     */
    public HelpDesk getDeskByOwnerOccupant(HEntity occupant) {
        HelpDesk result = null;
        for (HelpDesk pair : helpDesks) {
            UserAwareTile ownerTile = pair.owner;
            assert ownerTile != null;
            if (ownerTile.occupant != null && ownerTile.occupant.getName().equals(occupant.getName())) {
                result = pair;
            }
        }

        return result;
    }

    /**
     * @param occupant HEntity
     * @return HelpDesk
     */
    public HelpDesk getDeskByTenantOccupant(HEntity occupant) {
        HelpDesk result = null;
        for (HelpDesk pair : helpDesks) {
            UserAwareTile tenantTile = pair.tenant;
            assert tenantTile != null;
            if (tenantTile.occupant != null && tenantTile.occupant.getName().equals(occupant.getName())) {
                result = pair;
            }
        }

        return result;
    }

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

    public void printHelpDesks() {
        System.out.println("All HelpDesks: ");
        for (HelpDesk desk : helpDesks) {
            HEntity ownerOccupant = desk.owner.occupant;
            HEntity tenantOccupant = desk.tenant.occupant;
            String ownerName = ownerOccupant == null ? "null" : ownerOccupant.getName();
            String tenantName = tenantOccupant == null ? "null" : tenantOccupant.getName();
            System.out.println("Owner " + ownerName + " - Tenant: " + tenantName);
        }
    }

}
