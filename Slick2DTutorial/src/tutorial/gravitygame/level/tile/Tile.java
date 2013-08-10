package tutorial.gravitygame.level.tile;

import tutorial.gravitygame.level.LevelObject;
import tutorial.gravitygame.physics.BoundingShape;

public class Tile extends LevelObject {
	protected int x;
	protected int y;
	protected BoundingShape boundingShape;
	
	public Tile(int x, int y){
		super(x, y);
		boundingShape = null;
	}
	
}
