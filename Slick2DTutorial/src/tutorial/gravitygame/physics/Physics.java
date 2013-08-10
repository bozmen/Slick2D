package tutorial.gravitygame.physics;

import java.util.ArrayList;

import tutorial.gravitygame.level.Level;
import tutorial.gravitygame.level.LevelObject;
import tutorial.gravitygame.level.tile.Tile;

public class Physics {
	private final float gravity = 0.0015f;
	
	public void handlePhysics(Level level, int delta){
		
	}
	
	private boolean checkCollision(LevelObject obj, Tile[][] mapTiles){
		ArrayList<Tile> tiles = obj.getBoundingShape().getTilesOccupying(mapTiles);
		for(Tile t: tiles){
			//if this tile has a bounding shape
			if(t.getBoundingShape() != null) {
				if(t.getBoundingShape().checkCollision(obj.getBoundingShape())){
					return true;
				}
			}
		}
		return false;
	}
}
