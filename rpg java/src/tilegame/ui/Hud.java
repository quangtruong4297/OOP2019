package tilegame.ui;

import tilegame.Handler;
import tilegame.entities.creatures.Hero;
import tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hud {

    private Handler handler;
    private BufferedImage avatar;
    private int barWidth = 160;
    private int barHeight = 27;

    public Hud(Handler handler) {
        this.handler = handler;
        avatar = Assets.avatar;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        renderAvatar(g);
        renderBar(g);
    }

    public void renderAvatar(Graphics g) {
        g.drawImage(avatar, 8, 8, 64, 64, null);

        g.setColor(Color.black);
        g.drawRect(8, 8, 64, 64);
    }

    public void renderBar(Graphics g) {
        int health = handler.getWorldManager().getHero().getHealth();
        int MAX_HEALTH = Hero.MAX_HEALTH;
        int mana = handler.getWorldManager().getHero().getMana();
        int MAX_MANA = Hero.MAX_MANA;

        g.setColor(Color.black);
        g.fillRect(80, 8 , barWidth, barHeight);
        g.fillRect(80, 45 , barWidth, barHeight);

        if(health > MAX_HEALTH / 3)
            g.setColor(Color.green);
        else
            g.setColor(Color.red);
        g.fillRect(80, 8 , (barWidth * health) / MAX_HEALTH, barHeight);

        g.setColor(Color.cyan);
        g.fillRect(80, 45 , (barWidth * mana) / MAX_MANA, barHeight);

        g.setColor(Color.black);
        g.drawRect(80, 8, barWidth , barHeight );
        g.drawRect(80, 45, barWidth, barHeight);

    }

}
