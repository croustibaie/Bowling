

import static org.junit.Assert.*;

import org.junit.*;

public class TestBasic  {
	
	@Test
	public void testPartie() {
		Partie partie = new Partie();
		assertNotNull(partie);
	}
	
	@Test
	public void testNbJoueurs(){
		Partie partie = new Partie();
		
		partie.setNb_joueurs(5);
		assertTrue(partie.getNb_joueurs()==5);
		
	}
	
	@Test
	public void testLancers(){
		Joueur joueur = new Joueur("Bob");
		
		joueur.lancer(4,4);
		
		assertTrue(joueur.getScore()==8);
		
		
	}
}