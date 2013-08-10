package tutorial.gravitygame.character;

import java.util.HashMap;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import tutorial.gravitygame.enums.Facing;
import tutorial.gravitygame.level.LevelObject;

public abstract class Character extends LevelObject {
	
	protected Facing facing;
	
	protected HashMap<Facing, Image> sprites;
	protected HashMap<Facing, Animation> movingAnimations;
	
	protected boolean moving = false;
	
	protected float accelerationSpeed = 1;
	protected float decelerationSpeed = 1;
	protected float maximumSpeed = 1;
	
	public Character(float x, float y) throws SlickException{
		super(x, y);
		
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
		if(movingAnimations != null && moving){
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
	
	public boolean isMoving(){
		return moving;
	}
	
	public void setMoving(boolean b){
		moving = b;
	}
	
	public void decelerate(int delta){
		if(x_velocity > 0){
			x_velocity -= decelerationSpeed*delta;
			if(x_velocity < 0){
				x_velocity = 0;
			} else if(x_velocity < 0){
				x_velocity += decelerationSpeed*delta;
				if(x_velocity > 0)
					x_velocity = 0;
			}
		}
	}
	
	public void jump(){
		if(onGround){
			y_velocity = -0.4f;
		}
	}
	
	public void moveLeft(int delta){
		// if we aren't already moving at max speed
		if(x_velocity > -maximumSpeed){
			//accelerate
			x_velocity -= accelerationSpeed*delta;
			if(x_velocity < -maximumSpeed) {
				x_velocity = maximumSpeed;
			}
		}
		moving = true;
		facing = Facing.RIGHT;
	}
	
	public void moveRight(int delta){
		
		if(x_velocity < maximumSpeed){
			//accelerate 
			x_velocity += accelerationSpeed*delta;
			if(x_velocity > maximumSpeed){
				x_velocity = maximumSpeed;
			}
		}
		moving = true;
		facing = Facing.RIGHT;
	}
}
