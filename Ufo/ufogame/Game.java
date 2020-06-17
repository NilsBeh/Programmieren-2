package ufogame;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;

public class Game implements ITickableListener, IKeyboardListener {

	// Idea: we want to have multiple instances of an ufo and of a projectile
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
//	private Ufo [] ufos = new Ufo[10];
//	private Projectile [] projectiles = new Projectile[30];
	private Ship ship;
	private int screenWidth = 900;
	private int screenHeight = 700;
	private GameFrameWork frameWork = new GameFrameWork();
	public int score = 0;

	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("01Vorlesung\\assets\\space14.jpg"));
		
		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9,
				"01Vorlesung\\assets\\ship23.png");
		frameWork.addGameObject(ship);

		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 1,
				"01Vorlesung\\assets\\ufo20.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);

		for (int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}

		frameWork.addTick(this);
		frameWork.addIKeyInput(this);

	}

	public void shoot() {
		Projectile projectile = new Projectile(ship.getX() + ship.getWidth()/4, 
				ship.getY() - ship.getWidth() / 2, ship.getWidth() / 2, ship.getWidth() / 2, 3,
				"01Vorlesung\\assets\\projectile06.png");
		projectiles.add(projectile);

		frameWork.addGameObject(projectile);

//		for(int i = 0; i < 1000; i++) {
//			projectiles.add(projectile);
//		}
//		
//		for(Projectile p : projectiles) {
//			System.out.println(p.getImagePath());
//		}
		// Variante Array
		// projectiles[0] = projectile;

		// projectiles.get(0).getWidth();
		// Variante Array
		// projectiles[0].getWidth();

		// projectiles.size();
		// Variante Array
		// projectiles.lenght
	}
	
//HA Aufgabe 2
	public boolean checkCollision(Projectile, Ufo) {
		if (ufos.ufo.getX() < projectiles.p.getX() + projectiles.p.getWidth() &&
			ufos.ufo.getY() < projectiles.p.getY() + projectiles.p.getHeight() &&
			ufos.ufo.getX() + ufos.ufo.getWidth() < projectiles.p.getX() &&
			ufos.ufo.getY() + ufos.ufo.getHeight() < projectiles.p.getY()) {
				return true;
		} else {
			return false;
		}
	}

	@Override
	public void tick(long elapsedTime) {
		for (Ufo ufo : ufos) {
			ufo.move();
		}
		if (ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() - 1));
		}
		
		for(Projectile p: projectiles) {
            p.move();
        }
		
//HA Aufgabe 1
		if (projectiles.get(0).getY() > screenHeight) {
			frameWork.removeGameObject(projectiles.get(0));
			projectiles.remove(0);
		}
		
//HA Aufgabe 3
//Ich verstehe nicht was der Fehler bei der checkCollision Abfrage ist, eigentlich müsste dies so funktionieren :/
		
		for (Projectile p: projectiles) {
			for (Ufo ufo: ufos) {
				if (checkCollision(p,ufo) == true) {
					projectiles.remove(p);
					ufos.remove(ufo);
					score += 1;
					System.out.println(score);
				}
			}
		}
	}

	@Override
	public int[] getKeys() {
		int [] keys = {KeyEvent.VK_SPACE};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		shoot();
		
	}

}
