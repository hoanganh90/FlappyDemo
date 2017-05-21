package xploremedia.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.lang.reflect.Array;

import xploremedia.game.FlappyDemo;
import xploremedia.game.sprites.Bird;
import xploremedia.game.sprites.Tube;

/**
 * Created by Anh on 5/17/2017.
 */
public class PlayState extends State {
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private Bird bird;
    private Texture bg;

    private Array<Tube>tubes;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        //bird = new Texture("bird.png");
        bird = new Bird(0,300);
        cam.setToOrtho(false, FlappyDemo.WIDTH/2, FlappyDemo.HEIGHT/2);
        bg = new Texture("background.jpg");

        tubes = new Array<Tube>();
        for(int i = 1; i < TUBE_COUNT; i++){
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            bird.jump();
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
        sb.draw(tube.getBottomTube(),tube.getPosBottomTube().x, tube.getPosBottomTube().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
