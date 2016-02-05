import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Partie {
	
	private List<Joueur> playerList;
	private int currentPlayer;
	
	Partie(){
		currentPlayer = 0;
		playerList=new ArrayList<Joueur>();
	}

	Partie(int nb)
	{
		playerList=new ArrayList<Joueur>();
		currentPlayer = 0;
		for (int i=0;i<nb;i++)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Insert player number" + i + ":");
			String name=sc.nextLine();
			setJoueur(new Joueur (name));
		}
	}
	
	public int getNbJoueurs(){
		return this.playerList.size();
	}

	public void setJoueur(Joueur player)
	{
		playerList.add(player);
	}

	public Joueur getJoueur(int playerNum)
	{
		return playerList.get(playerNum);
	}
	
	public void nextPlayer(){
		currentPlayer = (currentPlayer + 1) % playerList.size();
	}
	
	public Joueur getCurrentPlayer(){
		return playerList.get(currentPlayer);
	}

	public List<ScorePair> getAllPlayersScore()
	{
		List<ScorePair> list=new ArrayList<ScorePair>();
		for (Joueur j : playerList)
		{
			list.add(new ScorePair(j.getScore(),playerList.indexOf(j)));
		}
		return list;
	}
}
