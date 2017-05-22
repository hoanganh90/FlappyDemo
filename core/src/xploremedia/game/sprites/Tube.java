package xploremedia.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.awt.Rectangle;
import java.util.Random;

/**
 * Created by Anh on 5/18/2017.
 */
public class Tube
{
    public static final int TUBE_WIDTH = 52;
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENNING = 120;
    private Texture topTube;
    private Texture bottomTube;
    private Vector2 posTopTube, posBottomTube;
    private Random rand;
    private Rectangle boundsTop, boundsBot;
    public Tube(float x){
        bottomTube = new Texture("toptube.png");
        topTube  = new Texture("bottomtube.png");
        rand = new Random();

        posTopTube = new Vector2(x,rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENNING);
        posBottomTube = new Vector2(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop = new Rectangle((int)posTopTube.x, (int)posTopTube.y, topTube.getWidth(),topTube.getHeight());
        boundsBot = new Rectangle((int)posTopTube.x, (int)posBottomTube.y, bottomTube.getWidth(), bottomTube.getHeight());



    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public void reposition(float x){
        posTopTube.set(x, rand.nextInt(FLUCTUATION)+ TUBE_GAP + LOWEST_OPENNING);
        posBottomTube.set(x,posTopTube.y - TUBE_GAP - bottomTube.getHeight());

        boundsTop.setLocation((int)posTopTube.x, (int)posTopTube.y);
        boundsBot.setLocation((int)posBottomTube.x, (int)posBottomTube.y);

    }
    public boolean collides(Rectangle player){
        return player.intersects(boundsTop)|| player.intersects(boundsBot);
    }
    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }
}
