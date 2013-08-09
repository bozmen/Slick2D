package tutorial.gravitygame.controller;

import org.newdawn.slick.Input;

import tutorial.gravitygame.character.Player;

public class MouseAndKeyboardPlayerController extends PlayerController {

	public MouseAndKeyboardPlayerController(Player player) {
		super(player);
	}

	@Override
	public void handleInput(Input i, int delta) {
		handleKeyboardInput(i, delta);
	}
	
	public void handleKeyboardInput(Input i, int delta) {
		// preventing from pressing multiple buttons like right-left at the same time
		if(i.isKeyDown(Input.KEY_A) || i.isKeyDown(Input.KEY_LEFT)){
			player.moveLeft(delta);
		} else if (i.isKeyDown(Input.KEY_D) || i.isKeyDown(Input.KEY_RIGHT)){
			player.moveRight(delta);
		}
	}

}
