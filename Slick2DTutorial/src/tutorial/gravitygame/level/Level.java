package tutorial.gravitygame.level;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import tutorial.gravitygame.character.Character;
import tutorial.gravitygame.level.tile.AirTile;
import tutorial.gravitygame.level.tile.SolidTile;
import tutorial.gravitygame.level.tile.Tile;

public class Level {
	private TiledMap map;
	private ArrayList<Character> characters;
	private Tile[][] tiles;
	
	public Level(String level) throws SlickException{
		map = new TiledMap("res/gravitygame/map/" + level + ".tmx", "res/gravitygame/tile/");
		characters = new ArrayList<Character>();
		
		loadTileMap();
	}
	
	public void addCharacter(Character c){
		characters.add(c);
	}
	
	public ArrayList<Character> getCharacters(){
		return characters;
	}
	
	public void render(){
		// rendering map
		map.render(0, 0, 0, 0, 32, 18);
		
		//rendering characters on top of the map
		for(Character c: characters){
			c.render();
		}
	}
	
	private void loadTileMap(){
		tiles = new Tile[map.getWidth()][map.getHeight()];
		
		int layerIndex = map.getLayerIndex("CollisionLayer");
		
		if(layerIndex == -1){
			System.err.println("Map doesn't have the layer \"CollisionLayer\"");
			System.exit(0);
		}
		
		//looping through the whole map
		for(int x = 0; x < map.getWidth(); x++){
			for(int y = 0; y < map.getHeight(); y++){
				
				//get the tile
				int tileID = map.getTileId(x, y, layerIndex);
				
				Tile tile = null;
				
				//what tile is it?
				switch(map.getTileProperty(tileID, "tileType", "solid")){
					case "air":
						tile = new AirTile(x, y);
						break;
					default:
						tile = new SolidTile(x, y);
						break;
				}
				tiles[x][y] = tile;
			}
		}
	}
	
    public Tile[][] getTiles(){
        return tiles;
    }
}
