package tutorial.animations;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class RudolfState extends BasicGameState {

	private SpriteSheet rudSprite;
	private Animation rudAnim;
	
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		SpriteSheet rudSprite = new SpriteSheet(new Image("res/rudolf_3.png").getSubImage(0, 0, 570, 95), 96, 95);
		rudAnim = new Animation(rudSprite, 100);
		
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawAnimation(rudAnim, 100, 100);
	}

	public void update(GameContainer container, StateBasedGame game, int arg2)
			throws SlickException {
		if(container.getInput().isKeyPressed(Input.KEY_Q)){
			game.enterState(2);
		}
	}

	public int getID() {
		return 1;
	}
	
}
