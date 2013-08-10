package tutorial.gravitygame.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import tutorial.gravitygame.enums.Facing;
import tutorial.gravitygame.physics.AABoundingRect;

public class Player extends Character {

	public Player(float x, float y) throws SlickException {
		super(x, y);
		setSprite(new Image("res/gravitygame/char/player.png"));
		setAnimation(new Image[]{new Image("res/gravitygame/char/player_1.png"),
								 new Image("res/gravitygame/char/player_2.png"),
								 new Image("res/gravitygame/char/player_3.png"),
								 new Image("res/gravitygame/char/player_4.png")},124);
		boundingShape = new AABoundingRect(x+3, y, 26, 32);
		
		accelerationSpeed = 0.001f;
		maximumSpeed = 0.15f;
		maximumFallSpeed = 0.3f;
		decelerationSpeed = 0.001f;	
	}
	
	public void updateBoundingShape(){
		boundingShape.updatePosition(x+3, y);
	}
}
