package tutorial.particles;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ParticlesMain extends StateBasedGame{

	public ParticlesMain(String name) {
		super(name);
	}

	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new SleepParticleState());
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new ParticlesMain("Particles"), 500, 500, false);
		
		container.start();
	}
}
