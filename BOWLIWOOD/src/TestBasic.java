

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
		partie.setJoueur(new Joueur ("bob"));
		partie.setJoueur(new Joueur ("michael"));
		partie.setJoueur(new Joueur ("Alice"));
		
		assertTrue(partie.getNbJoueurs()==3);
		
	}
	
	@Test
	public void testLancers() throws RaiseException{
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
		Partie partie= new Partie();
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
	
	@Test
	public void testNextPlayer()
	{
		Partie partie=new Partie();
		partie.setJoueur(new Joueur ("bob"));
		partie.setJoueur(new Joueur ("michael"));
		partie.setJoueur(new Joueur ("Alice"));
		
		partie.nextPlayer();
		partie.nextPlayer();
		partie.nextPlayer();
		assertTrue(partie.getCurrentPlayer().getName().equals("bob"));	
	}
	
	@Test(expected=RaiseException.class)
	public void testLimitationScore() throws RaiseException
	{
		Joueur joueur = new Joueur("Bob");
		joueur.lancer(5, 7);
	}

	@Test
	public void testGetScore () throws  RaiseException
	{
		Partie partie = new Partie();
		partie.setJoueur(new Joueur("Bob"));
		partie.setJoueur(new Joueur("Joe"));
		partie.getCurrentPlayer().lancer(4,4);
		partie.nextPlayer();
		partie.getCurrentPlayer().lancer(2,0);
		assertNotNull(partie.getAllPlayersScore());
		assertTrue(partie.getAllPlayersScore().get(0).getScore()==8);
		assertTrue(partie.getAllPlayersScore().get(1).getScore()==2);
		assertFalse(partie.getAllPlayersScore().get(1).getScore()==6);
		assertFalse(partie.getAllPlayersScore().size()==1);
	}

	@Test
	public void testPlayerLeaves()
	{
		Partie partie= new Partie();
		partie.setJoueur(new Joueur("Bob"));
		partie.setJoueur(new Joueur("Joe"));
		partie.setJoueur(new Joueur("Moe"));
		partie.removeCurrentPLayer();
		assertTrue(partie.getNbJoueurs()==2);
		assertFalse(partie.getNbJoueurs()==3);

	}

	@Test
	public void testSpareScore() throws RaiseException
	{
		Partie partie= new Partie();
		partie.setJoueur(new Joueur("Bob"));
		partie.getCurrentPlayer().lancer(1,9);
		partie.getCurrentPlayer().lancer(2,0);
		int s=partie.getCurrentPlayer().getRound(0).getRoundScore();
		assertTrue(s==12);
		assertFalse(s==11);
	}
}