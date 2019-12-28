package tilegame.worlds;

import tilegame.Handler;
import tilegame.entities.creatures.Hero;
import tilegame.entities.creatures.ListMonsters;

import java.awt.*;
import java.util.ArrayList;


public class WorldManager {
    public final static int BOSS_COUNT = 3;

    private Handler handler;
    private ArrayList<World> worlds;
    private Hero hero;
    ListMonsters listMonsters;

    private int bossKilled;
    private World world;

    public WorldManager(Handler handler) {
        worlds = new ArrayList<>();
        hero = new Hero(handler, 0, 0);

        listMonsters = new ListMonsters(handler);
        //add new world

        worlds.add(new World1(handler, "src/res/worlds/world1.txt", hero, listMonsters.getMonstersMap1()));
        worlds.add(new World2(handler, "src/res/worlds/world2.txt", hero, listMonsters.getMonstersMap2()));
        worlds.add(new World3(handler, "src/res/worlds/world3.txt", hero, listMonsters.getMonstersMap3()));

        world = worlds.get(0);
        world.setHeroSpawn();

        bossKilled = 0;

    }

    public void createPortal(){
        for (World w: worlds) {
            w.createPortal();
        }
    }

    public void tick() {
        world.tick();
    }

    public void render(Graphics g) {
        world.render(g);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<World> getWorlds() {
        return worlds;
    }

    public Hero getHero() {
        return hero;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getBossKilled() {
        return bossKilled;
    }

    public void setBossKilled(int bossKilled) {
        this.bossKilled = bossKilled;
    }
}
