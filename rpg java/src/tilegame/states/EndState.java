package tilegame.states;

import tilegame.Handler;
import tilegame.gfx.Assets;
import tilegame.gfx.Text;


import java.awt.*;

public class EndState extends State {

    private static final long COOLDOWN = 2000;
    private long timer = 0;

    private static final long COOLDOWN_TEXT = 1000;
    private long timerText = 0;

    private long lastTime =  System.currentTimeMillis();

    public EndState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        timer += (System.currentTimeMillis() - lastTime);
        timerText += (System.currentTimeMillis() - lastTime);

        lastTime = System.currentTimeMillis();

        if(timer < COOLDOWN)
            return;
        if(handler.getKeyManager().pressedAnyKey){
            System.exit(0);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.backgroundWall, 0, 0, null);
        if (timerText > COOLDOWN_TEXT) {
            timerText = 0;
        }
        else {
            if(timerText > (COOLDOWN_TEXT >> 2) )
                Text.drawString(g, "PRESS ANY KEY TO EXIT", 
                    handler.getWidth() >> 1, handler.getHeight() - (handler.getHeight() >> 2), true, Color.white, Assets.font40);
        }
    }
}
