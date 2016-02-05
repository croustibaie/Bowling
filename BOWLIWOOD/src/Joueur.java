import java.util.Scanner;

class Joueur {
	
	private String name;
	
	private int score;
	
	Joueur()
	{
		this.score = 0;
	}
	
	Joueur(String name){
		this.name = name;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void lancer(int l1,int l2) throws RaiseException{
		if (l1+l2 > 10)
		{
			throw new RaiseException();
		}
		else
		{
			this.score += l1 +l2;
		}
	}

}
