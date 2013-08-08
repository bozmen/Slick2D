package tutorial.animations;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class AnimationMain extends StateBasedGame{

	public AnimationMain(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new RudolfState());
		this.addState(new ExplosionState());
	}
	
	public static void main(String[] args) throws SlickException{
		AnimationMain main = new AnimationMain("Animations");
		
		AppGameContainer game = new AppGameContainer(main, 500, 500, false);
		game.setTargetFrameRate(60);
		game.start();
		
	}
	
}
