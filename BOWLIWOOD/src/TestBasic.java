

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

	@Test
	public void testJoueur()
	{
		Joueur joueur= new Joueur("bob");
		assertNotNull(joueur);
	}

	@Test
	public void testAddedPlayer()
	{
		Partie partie= new Partie(1);
		partie.setJoueur(new Joueur("bob"));
		assertTrue(partie.getJoueur(0).getName().equals("bob"));
	}

	@Test
	public void automaticAddPlayers()
	{
		Partie partie=new Partie();
		partie.setJoueur(new Joueur ("bob"));
		partie.setJoueur(new Joueur ("michael"));
		assertNotNull(partie.getJoueur(0));
		assertNotNull(partie.getJoueur(1));
	}
}