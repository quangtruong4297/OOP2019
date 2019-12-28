package tilegame.portals;

import java.awt.*;
import java.util.ArrayList;



public class PortalManager {

    private ArrayList<Portal> portals;

    public PortalManager() {
        portals = new ArrayList<>();

    }

    public void addPortal(Portal portal) {
        portals.add(portal);
    }

    public void tick() {
        for(Portal p : portals) {
            p.tick();
        }
    }

    public void render(Graphics g) {
        for(Portal p : portals) {
            p.render(g);
        }
    }


}
