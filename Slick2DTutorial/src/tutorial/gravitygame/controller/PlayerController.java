package tutorial.gravitygame.controller;

import org.newdawn.slick.Input;

import tutorial.gravitygame.character.Player;

public abstract class PlayerController {

	protected Player player;
	
	public PlayerController(Player player){
		this.player = player;
	}
	
	public abstract void handleInput(Input i, int delta);
}
