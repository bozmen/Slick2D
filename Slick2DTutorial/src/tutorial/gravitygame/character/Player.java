package tutorial.gravitygame.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {

	public Player(float x, float y) throws SlickException {
		super(x, y);
		sprite = new Image("res/gravitygame/char/player.png");
	}
	
}
