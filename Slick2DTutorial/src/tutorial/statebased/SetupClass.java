package tutorial.statebased;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SetupClass extends StateBasedGame{	
	
	public static int gameScore = 0;
	public static int lives = 3;
	
	public SetupClass(String title) {
		super(title);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer game = new AppGameContainer(new SetupClass("My Game."), 500, 500, false);
		
		game.setTargetFrameRate(60);
		game.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new GameState());
		this.addState(new GameOverState());
	}
}
