package tilegame.states;

import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.tiles.Tile;

import tilegame.ui.ClickListener;
import tilegame.ui.UIImageButton;
import tilegame.ui.UIManager;

import java.awt.*;


public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(handler.getWidth()/2 - Tile.TILE_WIDTH,
                handler.getHeight()/2 + Tile.TILE_HEIGHT,
                Tile.TILE_WIDTH*2,
                Tile.TILE_HEIGHT,
                Assets.btn_start,
                new ClickListener(){
                    @Override
                    public void onClick() {
                        handler.getMouseManager().setUIManager(null);
                        State.setState(handler.getGame().gameState);
                    }
                }));

        uiManager.addObject(new UIImageButton(handler.getWidth()/2 - Tile.TILE_WIDTH,
                handler.getHeight()/2 + Tile.TILE_HEIGHT * 2,
                Tile.TILE_WIDTH*2,
                Tile.TILE_HEIGHT,
                Assets.btn_exit,
                new ClickListener(){
                    @Override
                    public void onClick() {
                        System.exit(0);
                    }
                }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        wallpaper(g);
        uiManager.render(g);
    }

    public void wallpaper(Graphics g) {
        g.drawImage(Assets.backgroundWall, 0,0 ,null);
    }

}
