import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Partie {
	
	private int nb_joueurs;
	private List<Joueur> playerList;
	
	Partie(){
		nb_joueurs=0;
		playerList=new ArrayList<Joueur>();
	}

	Partie(int nb)
	{
		playerList=new ArrayList<Joueur>();
		nb_joueurs=nb;
		for (int i=0;i<nb_joueurs;i++)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Insert player number" + i + ":");
			String name=sc.nextLine();
			setJoueur(new Joueur (name));
		}
	}

	public void setNb_joueurs(int n){
		this.nb_joueurs = n;
	}
	
	public int getNb_joueurs(){
		return this.nb_joueurs;
	}

	public void setJoueur(Joueur player)
	{
		playerList.add(player);
	}

	public Joueur getJoueur(int playerNum)
	{
		return playerList.get(playerNum);
	}
}
