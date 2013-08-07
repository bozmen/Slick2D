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

public class ExplosionState extends BasicGameState{

	private SpriteSheet expSheet;
	private Animation expAnim;
	
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		expSheet = new SpriteSheet(new Image("res/firen_exp.png"), 160, 160);
		expAnim = new Animation(expSheet, 100);
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		expAnim.draw(150, 150);
	}

	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		if(container.getInput().isKeyPressed(Input.KEY_Q)){
			game.enterState(1);
		}
		
	}

	public int getID() {
		return 2;
	}

}
