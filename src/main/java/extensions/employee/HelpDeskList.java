package extensions.employee;

import gearth.extensions.parsers.HEntity;
import gearth.extensions.parsers.HPoint;
import java.util.ArrayList;

public class HelpDeskList {

    private ArrayList<HelpDesk> helpDesks = new ArrayList<>();

    public HelpDeskList() {
        helpDesks.add(new HelpDesk(new HPoint(10, 29), new HPoint(12, 29), "back"));
        helpDesks.add(new HelpDesk(new HPoint(10, 27), new HPoint(12, 27), "back"));
        helpDesks.add(new HelpDesk(new HPoint(10, 23), new HPoint(12, 23), "back"));
        helpDesks.add(new HelpDesk(new HPoint(10, 21), new HPoint(12, 21), "back"));
        helpDesks.add(new HelpDesk(new HPoint(25, 10), new HPoint(25, 12), "back"));
        helpDesks.add(new HelpDesk(new HPoint(27, 10), new HPoint(27, 12), "back"));
        helpDesks.add(new HelpDesk(new HPoint(29, 10), new HPoint(29, 12), "back"));
        helpDesks.add(new HelpDesk(new HPoint(17, 30), new HPoint(20, 30), "front"));
        helpDesks.add(new HelpDesk(new HPoint(17, 28), new HPoint(20, 28), "front"));
        helpDesks.add(new HelpDesk(new HPoint(17, 25), new HPoint(20, 25), "front"));
        helpDesks.add(new HelpDesk(new HPoint(17, 23), new HPoint(20, 23), "front"));
        helpDesks.add(new HelpDesk(new HPoint(23, 17), new HPoint(23, 20), "front"));
        helpDesks.add(new HelpDesk(new HPoint(25, 17), new HPoint(25, 20), "front"));
        helpDesks.add(new HelpDesk(new HPoint(28, 17), new HPoint(28, 20), "front"));
        helpDesks.add(new HelpDesk(new HPoint(30, 17), new HPoint(30, 20), "front"));
        helpDesks.add(new HelpDesk(new HPoint(17, 4), new HPoint(17, 7), "security"));
        helpDesks.add(new HelpDesk(new HPoint(20, 4), new HPoint(20, 7), "security"));
    }

    /**
     * @param occupant HEntity´
     */
    public void clearOccupancesForEntity(HEntity occupant) {
        HelpDesk desk = this.getDeskByOwnerOccupant(occupant);
        if(desk != null) desk.owner.occupant = null;
        desk = this.getDeskByTenantOccupant(occupant);
        if(desk != null) desk.tenant.occupant = null;
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
            if (ownerTile.occupant != null && ownerTile.occupant.getName().equals(occupant.getName()) && ownerTile.occupant.getEntityType() == occupant.getEntityType()) {
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
            if (tenantTile.occupant != null && tenantTile.occupant.getName().equals(occupant.getName()) && tenantTile.occupant.getEntityType() == occupant.getEntityType()) {
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
            System.out.println("Owner " + ownerName + " - Tenant: " + tenantName + " - Type: " + desk.type);
        }
    }

    public void clear() {
        for (HelpDesk desk : helpDesks) {
            desk.owner.occupant = null;
            desk.tenant.occupant = null;
        }
        System.out.println("Clear all occupants");
    }

}
