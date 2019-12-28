package tilegame.items;

import tilegame.Handler;
import tilegame.entities.creatures.Hero;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Item {

    public static Item[] items = new Item[256];
    public static Item woodItem = new Item(Assets.wood, "Wood", 0);
    public static Item stoneItem = new Item(Assets.stone, "Stone", 1);
    public static Item heartitem = new Item(Assets.heart, "heart", 2);
    public static Item manaitem = new Item(Assets.mana, "mana", 3);
    public static Item Severrumitem = new Item(Assets.Severum, "Severum", 4);
    public static Item Calibrumitem = new Item(Assets.Calibrum, "Calibrum", 5);
    public static Item Infernumitem = new Item(Assets.Infernum, "Infernum", 6);



    public static final int ITEM_WIDTH = 64, ITEM_HEIGHT = 64;

    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;

    protected Rectangle bounds;

    protected int x, y, count;
    protected boolean pickedUp = false;


    public Item(BufferedImage texture, String name, int id) {
        this.id = id;
        this.name = name;
        this.texture = texture;
        count = 1;

        bounds = new Rectangle(0, 0, ITEM_WIDTH, ITEM_HEIGHT);
        items[id] = this;
    }

    public void tick() {
        if(handler.getWorldManager().getWorld().getEntityManager().getHero().getCollisionBounds(0, 0).intersects(bounds.x + x, bounds.y + y, bounds.width, bounds.height)
                && handler.getKeyManager().collect) {
        	Hero hero = null;
        
			  switch (id) { 
			  	case 2: 
				  int m = handler.getWorldManager().getWorld().getEntityManager().getHero().getHealth()+ 10;
				  if (m > Hero.MAX_HEALTH) m = Hero.MAX_HEALTH ;
				  	handler.getWorldManager().getWorld().getEntityManager().getHero().setHealth(m); 
				  	pickedUp = true;
				  	handler.getWorldManager().getWorld().getEntityManager().getHero().getInventory().addItem(this); 
				  break; 
				case 3: 
					int n = handler.getWorldManager().getWorld().getEntityManager().getHero().getMana()+ 10;
					 if (n > Hero.MAX_MANA) n = Hero.MAX_MANA ;
					handler.getWorldManager().getWorld().getEntityManager().getHero().setMana(n); 
				  	pickedUp = true;
				  	handler.getWorldManager().getWorld().getEntityManager().getHero().getInventory().addItem(this); 
				  break;
				case 4: 
					handler.getWorldManager().getWorld().getEntityManager().getHero().setDame(
							handler.getWorldManager().getWorld().getEntityManager().getHero().getDamage() + 1); 
				  	pickedUp = true;
				  	handler.getWorldManager().getWorld().getEntityManager().getHero().getInventory().addItem(this);
				  	break;
				case 5:
					handler.getWorldManager().getWorld().getEntityManager().getHero().setMaxHealth(
							handler.getWorldManager().getWorld().getEntityManager().getHero().getMaxHealth() + 10); 
				  	pickedUp = true;
				  	handler.getWorldManager().getWorld().getEntityManager().getHero().getInventory().addItem(this); 
				  	break;
				case 6:
					handler.getWorldManager().getWorld().getEntityManager().getHero().setSPEED(
							handler.getWorldManager().getWorld().getEntityManager().getHero().getSPEED() + 1/2); 
				  	pickedUp = true;
				  	handler.getWorldManager().getWorld().getEntityManager().getHero().getInventory().addItem(this); 
				  	break;
				default: 
					pickedUp = true;
		            handler.getWorldManager().getWorld().getEntityManager().getHero().getInventory().addItem(this);
					break; }
			 
//        	
//        	if(id == 2) {
//        		int m = handler.getWorldManager().getWorld().getEntityManager().getHero().getHealth() + 10;
//        		if (m > hero.MAX_HEALTH) m = hero.MAX_HEALTH;	
//        			handler.getWorldManager().getWorld().getEntityManager().getHero().setHealth(m);
//        			pickedUp = true;
//                    handler.getWorldManager().getWorld().getEntityManager().getHero().getInventory().addItem(this);
//        	}
//        	else {
//            pickedUp = true;
//            handler.getWorldManager().getWorld().getEntityManager().getHero().getInventory().addItem(this);
//        	}
        }
    }

    public void render(Graphics g) {
        if (handler != null) {
            render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
        }
    }

    public void render(Graphics g, int x, int y) {

        g.drawImage(texture, x, y, ITEM_WIDTH, ITEM_HEIGHT, null);
    }

    public Handler getHandler() {
        return handler;
    }

    public Item createNew(int x, int y) {
        Item i = new Item(texture, name, id);
        i.setPosition(x, y);
        return i;
    }

    public Item createNew(int x, int y, int count) {
        Item i = new Item(texture, name, id);
        i.setPosition(x, y);
        i.setCount(count);
        return i;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }
}
