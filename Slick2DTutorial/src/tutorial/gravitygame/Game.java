package tutorial.gravitygame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import tutorial.gravitygame.levelstate.LevelState;

public class Game extends StateBasedGame {
	
	public static final int WINDOW_WIDTH = 1280;
	public static final int WINDOW_HEIGHT = WINDOW_WIDTH / 16 * 9;
	public static final boolean FULLSCREEN = false;
	
	public static final float SCALE = (float) (1.25 * ((double) WINDOW_WIDTH/1280));
	public static final String GAME_NAME = "Gravity Game";

	public Game() {
		super(GAME_NAME);
	}

	public void initStatesList(GameContainer arg0) throws SlickException {
		addState(new LevelState("level_0"));
		this.enterState(0);
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new Game(), WINDOW_WIDTH, WINDOW_HEIGHT, FULLSCREEN);
		container.setTargetFrameRate(60);
		container.start();
	}

}
