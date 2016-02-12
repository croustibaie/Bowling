import java.util.Scanner;

public class RunBowling {
	
	public static void main(String args[]) throws RaiseException
	{
		// initialization
		System.out.println("Enter player number: ");
		Scanner sc = new Scanner(System.in);
		int nb= sc.nextInt();
		Partie partie = new Partie(nb);

		//playing
		for (int i=0; i<10;i++)
		{
			System.out.println("You are playing round number " + (i+1) );
			for (int j=0; j<nb;j++)
			{
				boolean nextPlayer=false;
				System.out.println(partie.getCurrentPlayer().getName()+ ", your score is " + partie.getCurrentPlayer().getScore());
				while (nextPlayer==false)
				{
					System.out.println(partie.getCurrentPlayer().getName()+ " " + "Enter shoot:");
					int k = sc.nextInt();
					nextPlayer = !partie.getCurrentPlayer().shoot(k);
				}
				partie.nextPlayer();
			}
		}
		for (int i=0; i<nb;i++)
		{
			System.out.println(partie.getCurrentPlayer().getName()+ " Your final score is " + partie.getCurrentPlayer().getScore());
			partie.nextPlayer();
		}
	}

}
