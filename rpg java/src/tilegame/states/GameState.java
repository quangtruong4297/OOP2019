package tilegame.states;

import tilegame.Handler;
import tilegame.ui.Hud;
import tilegame.worlds.WorldManager;

import java.awt.*;


public class GameState extends State{

    private WorldManager worldManager;
    private Hud hud;

    public GameState(Handler handler) {
        super(handler);
        hud = new Hud(handler);
        worldManager = new WorldManager(handler);
        handler.setWorldManager(worldManager);
        worldManager.createPortal();
    }

    @Override
    public void tick() {
        worldManager.tick();
        hud.tick();
    }

    @Override
    public void render(Graphics g) {
        worldManager.render(g);
        hud.render(g);
    }
}
