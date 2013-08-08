package tutorial.particles;

import java.io.File;
import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class SleepParticleState extends BasicGameState {

	private ParticleSystem zSystem;
	private ConfigurableEmitter emitter;

	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		Image zImg = new Image("res/zz.png", false);
		zSystem = new ParticleSystem(zImg, 500);
		
		try {
			File z_xml = new File("res/test_emitter.xml");
			emitter = ParticleIO.loadEmitter(z_xml);
			emitter.setPosition(250, 250);
			zSystem.addEmitter(emitter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		zSystem.setBlendingMode(ParticleSystem.BLEND_ADDITIVE);
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		zSystem.render();
		arg2.drawString("TEST", 100, 115);
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		zSystem.update(arg2);
	}
	
	public void mousePressed(int button, int x, int y){
		emitter.setPosition(x, y, false);
	}
	
	public void mouseDragged(int oldx, int oldy, int newx, int newy){
		emitter.setPosition(newx, newy, false);
	}

	public int getID() {
		return 0;
	}

}
