package tilegame.entities.creatures;

import tilegame.Handler;
import tilegame.entities.Entity;
import tilegame.gfx.Animation;
import tilegame.gfx.Assets;
import tilegame.tiles.Tile;

import java.awt.*;


public class Kamezoko extends Creature {
    public static final int DEFAULT_COST = 4;
    public static int skillID;
    Animation fly_animation;

    public Kamezoko(Handler handler, float x, float y, CreatureDir dir, int ID) {
        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        this.damage = 2*handler.getWorldManager().getWorld().getEntityManager().getHero().getDamage();
        this.speed = speed*2;
        this.dir = dir;
        setDir();
        this.health = 200;
        skillID = ID;
        if(skillID==0)
        	fly_animation = new Animation(100, Assets.skill);
        else fly_animation = new Animation(100, Assets.skill1);

        bounds.x = Tile.TILE_WIDTH/3;
        bounds.y = Tile.TILE_HEIGHT/3;
        bounds.width = Tile.TILE_WIDTH/4;
        bounds.height = Tile.TILE_HEIGHT/4;
    }

    private void setDir() {
        if(dir == CreatureDir.up) {
            yMove = -speed;
        }
        else if(dir == CreatureDir.down) {
            yMove = +speed;
        }
        else if(dir == CreatureDir.left) {
            xMove = -speed;
        }
        else if(dir == CreatureDir.right) {
            xMove = speed;
        }
    }

    @Override
    public void tick() {
        fly_animation.tick();

        move();
        target();
        hurt((int)speed);
    }

    public void target() {
    	
        for(Entity e : handler.getWorldManager().getWorld().getEntityManager().getEntities()) {
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xMove , yMove ))){
            	if(skillID == 1) {
                e.hurt(damage);
            	}
            	else {
            		this.hurt(health);
                    e.hurt(damage);
            	}
            }
        }
    }
        
 

    @Override
    public void render(Graphics g) {
        int rx = (int) (x - handler.getGameCamera().getxOffset());
        int ry = (int) (y - handler.getGameCamera().getyOffset());
        g.drawImage(fly_animation.getCurrentFrame(), rx, ry, width, height, null);
    }

    @Override
    public void die() {
        /*die animation*/
    }

    public boolean isSolid() {
        return false;
    }

	public int getSkillID() {
		return skillID;
	}
}
