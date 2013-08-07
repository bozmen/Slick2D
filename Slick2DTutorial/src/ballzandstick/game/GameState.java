package ballzandstick.game;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameState extends BasicGameState {
	
	private ArrayList<Circle> balls;
	private Circle mouseBall;
	private int timePassed;
	private Random random;
	
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		balls = new ArrayList<Circle>();
		mouseBall = new Circle(0, 0, 20);
		timePassed = 0;
		random = new Random();
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		mouseBall.setCenterX(container.getInput().getMouseX());
		mouseBall.setCenterY(container.getInput().getMouseY());
		
		timePassed += delta;
		if(timePassed > 500){
			timePassed = 0;
			balls.add(new Circle(200 + random.nextInt(400), 0, 10));
		}
		
		for(Circle c : balls){
			c.setCenterY(c.getCenterY()+delta/5);
		}
		
		for(int i = balls.size()-1; i >= 0; i--){
			Circle c = balls.get(i);
			if(c.getCenterY() > 610){
				balls.remove(i);
				SetupClass.lives--;
			} else if (c.intersects(mouseBall)){
				balls.remove(i);
				SetupClass.gameScore++;
			}
		}
		
		if(SetupClass.lives <= 0){
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		g.setColor(Color.yellow);
		g.fill(mouseBall);
		
		g.setColor(Color.red);
		for(Circle c : balls){
			g.fill(c);
		}
		
		g.drawString("Current Ballz: " + balls.size(), 20, 50);
		g.drawString("Current lives: " + SetupClass.lives, 20, 65);
		g.drawString("Current points: " + SetupClass.gameScore, 20, 80);
	}


	public int getID() {
		return 0;
	}
	

}
