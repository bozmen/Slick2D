package tutorial.gravitygame.character;

import java.util.HashMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import tutorial.gravitygame.enums.Facing;

public abstract class Character {
	
	protected float x;
	protected float y;
	protected Facing facing;
	protected HashMap<Facing, Image> sprites;
	protected HashMap<Facing, Animation> movingAnimations;
	protected long lastTimeMoved;
	
	public Character(float x, float y) throws SlickException{
		this.x = x;
		this.y = y;
		
		setSprite(new Image("res/gravitygame/char/placeholder_sprite.png"));
		
		facing = Facing.RIGHT;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void render(){
		if(movingAnimations != null && lastTimeMoved+150 > System.currentTimeMillis()){
			movingAnimations.get(facing).draw(x-2, y-2);
		} else {
			sprites.get(facing).draw(x-2, y-2);
		}
	}
	
	protected void setSprite(Image i){
		sprites = new HashMap<Facing,Image>();
		sprites.put(Facing.RIGHT, i);
		sprites.put(Facing.LEFT, i.getFlippedCopy(true, false));
	}
	
	protected void setAnimation(Image[] images, int frameDuration){
		movingAnimations = new HashMap<Facing, Animation>();
		
		movingAnimations.put(Facing.RIGHT, new Animation(images, frameDuration));
		
		Animation facingLeftAnimation = new Animation();
		for(Image i : images){
			facingLeftAnimation.addFrame(i.getFlippedCopy(true, false), frameDuration);
		}
		movingAnimations.put(Facing.LEFT, facingLeftAnimation);
	}
}
