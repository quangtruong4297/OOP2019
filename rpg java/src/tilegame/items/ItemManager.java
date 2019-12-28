package tilegame.items;

import tilegame.Handler;

import java.awt.*;
import java.util.ArrayList;

public class ItemManager {

    private Handler handler;
    private ArrayList<Item> items;

    public ItemManager(Handler handler) {
        this.handler = handler;
        items = new ArrayList<>();
    }

    public void tick() {
        for(int i = 0; i < items.size(); ++i) {
            Item e = items.get(i);
            e.tick();
            if(e.isPickedUp()) {
                items.remove(e);
                i--;
            }
        }
    }

    public void render(Graphics g) {
        for(Item i : items) {
            i.render(g);
        }
    }

    public void addItem(Item i) {
        i.setHandler(handler);
        items.add(i);
    	
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
