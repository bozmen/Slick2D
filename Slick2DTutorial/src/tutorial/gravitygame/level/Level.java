package tutorial.gravitygame.level;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import tutorial.gravitygame.character.Character;;

public class Level {
	private TiledMap map;
	private ArrayList<Character> characters;
	
	public Level(String level) throws SlickException{
		map = new TiledMap("res/gravitygame/map/" + level + ".tmx", "res/gravitygame/tile/");
		characters = new ArrayList<Character>();
	}
	
	public void addCharacter(Character c){
		characters.add(c);
	}
	
	public void render(){
		// rendering map
		map.render(0, 0, 0, 0, 32, 18);
		
		//rendering characters on top of the map
		for(Character c: characters){
			c.render();
		}
	}
}
