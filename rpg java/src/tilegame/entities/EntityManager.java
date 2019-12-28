package tilegame.entities;

import tilegame.Handler;
import tilegame.entities.creatures.Hero;
import tilegame.entities.creatures.Monster;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;


public class EntityManager {

    private Handler handler;
    private Hero hero;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };

    public EntityManager(Handler handler, Hero hero, ArrayList<Monster> monsters) {
        this.handler = handler;
        this.hero = hero;
        entities = new ArrayList<>();
        addEntity(hero);
        monsters.forEach(this::addEntity);
    }

    public void tick() {
        for(int i = 0; i < entities.size(); ++i) {
            Entity e = entities.get(i);
            e.tick();
            if(!e.isActive()) {
                entities.remove(e);
                i--;
            }
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics g) {
        for(int i = 0; i < entities.size(); ++i) {
            Entity e = entities.get(i);
            e.render(g);
        }
        hero.renderPost(g);
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public Hero getHero() {
        return hero;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
