package tutorial.gravitygame.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import tutorial.gravitygame.enums.Facing;

public class Player extends Character {

	public Player(float x, float y) throws SlickException {
		super(x, y);
		setSprite(new Image("res/gravitygame/char/player.png"));
		setAnimation(new Image[]{new Image("res/gravitygame/char/player_1.png"),
								 new Image("res/gravitygame/char/player_2.png"),
								 new Image("res/gravitygame/char/player_3.png"),
								 new Image("res/gravitygame/char/player_4.png")},124);
	}

	public void moveLeft(int delta) {
		x = x - (0.15f*delta);
		facing = Facing.LEFT;
		lastTimeMoved = System.currentTimeMillis();
	}
	
	public void moveRight(int delta) {
		x = x + (0.15f*delta);
		facing = Facing.RIGHT;
		lastTimeMoved = System.currentTimeMillis();
	}
	
}
