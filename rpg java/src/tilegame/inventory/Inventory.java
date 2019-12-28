package tilegame.inventory;

import tilegame.Handler;
import tilegame.entities.creatures.Hero;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;
import tilegame.gfx.Text;
import tilegame.items.Item;
import tilegame.tiles.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Inventory {

    private Animation character;

    private Handler handler;
    private boolean active = false;
    private ArrayList<ItemSlot> itemSlots;
    private boolean picking = false;
    private ItemSlot curIS;

    private BufferedImage image;
    private int x, y, width, height;

    private int numCols = 9, numRows = 4;

    public Inventory(Handler handler) {
        this.handler = handler;
        image = Assets.inventory;
        width = image.getWidth();
        height = image.getHeight();
        x = handler.getWidth()/2 - width/4;
        y = handler.getHeight()/2 - height/4;
        int xIS = 25, yIS = 170;
        itemSlots = new ArrayList<>();
        for(int j = 0; j < numRows; ++j) {
            for(int i = 0; i < numCols; ++i) {
                itemSlots.add(new ItemSlot(i*ItemSlot.SLOT_SIZE + xIS + x, j*ItemSlot.SLOT_SIZE + yIS + y));
            }
        }

        character = new Animation(120, Assets.hero_down);
    }

    public void tick() {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_I)){
            active = !active;
        }
        if(!active)
            return;
        else {
            pick();
            split();

            character.tick();
        }
    }

    private void pick() {

        if(handler.getMouseManager().isLeftPressed()){
            for(ItemSlot is: itemSlots){
                if(is.getSlotBounds().contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())
                        && !picking) {
                    picking = true;
                    if(curIS == null) {
                        if(is.getItem() != null) {
                            curIS = is;
                        }
                    }else {
                        if(!is.equals(curIS)) {

                            if (!is.addItem(curIS.getItem())) {
                                is.swapItem(curIS);
                            } else {
                                curIS.setItem(null);
                            }
                        }
                        curIS = null;
                    }
                }
            }
            if(!getInventoryBounds().contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())
                    && curIS != null){
                drop(curIS.getItem());
                curIS = null;
            }
        }

        if(picking && !handler.getMouseManager().isLeftPressed()) {
            picking = false;
        }
    }

    private void drop(Item item) {

        item.setPickedUp(false);
        item.setX((int)(handler.getWorldManager().getHero().getX() + (Math.random()-0.5)*Tile.TILE_WIDTH*2));
        item.setY((int)(handler.getWorldManager().getHero().getY() + (Math.random()-0.5)*Tile.TILE_HEIGHT*2));
        handler.getWorldManager().getWorld().getItemManager().addItem(curIS.getItem());
        curIS.setItem(null);
        System.out.println(handler.getWorldManager().getWorld().getItemManager().getItems().size());
    }

    private void split() {
        if(handler.getMouseManager().isRightPressed()){
            for(ItemSlot is: itemSlots){
                if(is.getSlotBounds().contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())
                        && !picking) {
                    picking = true;
                    if(curIS == null) {
                        if(is.getItem() != null && is.getItem().getCount() > 1) {
                            curIS = new ItemSlot(0, 0);
                            curIS.setItem(Item.items[is.getItem().getId()].createNew(0, 0));
                            curIS.getItem().setCount(is.getItem().getCount()/2);
                            is.getItem().setCount(is.getItem().getCount() - curIS.getItem().getCount());
                        }
                    }
                }
            }
        }
    }

    public void render(Graphics g) {
        if(!active)
            return;
        g.drawImage(image, x, y, image.getWidth()/2, image.getHeight()/2, null);
        for(ItemSlot is : itemSlots){
            is.render(g);
        }

        if (curIS != null) {
            Item item = curIS.getItem();
            g.drawImage(item.getTexture(), handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), Tile.TILE_WIDTH/2, Tile.TILE_HEIGHT/2, null);
        }

        g.drawImage(character.getCurrentFrame(), x+Tile.TILE_WIDTH*3+Tile.TILE_WIDTH/4, y+Tile.TILE_HEIGHT/2+12, Tile.TILE_WIDTH, Tile.TILE_HEIGHT, null);
        Hero hero = handler.getWorldManager().getHero();
        Text.drawString(g, "HP: "+ hero.getHealth() + "/" + Hero.MAX_HEALTH, x+ Tile.TILE_WIDTH, y+Tile.TILE_HEIGHT/2+12, false, Color.BLACK, Assets.font15);
        Text.drawString(g, "MP: " + hero.getMana() + "/" + Hero.MAX_MANA, x+Tile.TILE_WIDTH, y+Tile.TILE_HEIGHT+12, false, Color.BLACK, Assets.font15);
        Text.drawString(g, "Damage: " + hero.getDamage(), x+Tile.TILE_WIDTH, y+Tile.TILE_HEIGHT*3/2+12, false, Color.BLACK, Assets.font15);

    }

    public void addItem(Item item) {
        for(ItemSlot is : itemSlots) {
            if(is.addItem(item))
                return;
        }
    }

    Rectangle getInventoryBounds() {
        return new Rectangle(x, y, width >> 1, height >>1);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
