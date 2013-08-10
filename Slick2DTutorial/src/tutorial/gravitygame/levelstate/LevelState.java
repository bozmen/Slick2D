package tutorial.gravitygame.levelstate;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import tutorial.gravitygame.Game;
import tutorial.gravitygame.character.Player;
import tutorial.gravitygame.controller.MouseAndKeyboardPlayerController;
import tutorial.gravitygame.controller.PlayerController;
import tutorial.gravitygame.level.Level;
import tutorial.gravitygame.physics.Physics;

public class LevelState extends BasicGameState{
	
	Level level;
	String startingLevel;
	Player player;
	PlayerController playerController;
	Physics physics;
	
	public LevelState(String startingLevel){
		this.startingLevel = startingLevel;
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException{
		// initializing level
		level = new Level(startingLevel);
		
		// adding characters to the map
		player = new Player(128, 416);
		level.addCharacter(player);
		
		// creating a input handler for player
		playerController = new MouseAndKeyboardPlayerController(player);
		
		// physics
	}

	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.scale(Game.SCALE, Game.SCALE);
		level.render();
	}

	public void update(GameContainer container, StateBasedGame gaame, int delta)
			throws SlickException {
		playerController.handleInput(container.getInput(), delta);
		physics.handlePhysics(level, delta);
	}
	
	public void keyPressed(int key, char code){
		if(key == Input.KEY_ESCAPE)
			System.exit(0);	
	}

	public int getID() {
		return 0;
	}
	
}
