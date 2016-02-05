import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Joueur {
	
	private String name;
	private List<Round> score;
	
	Joueur()
	{
		this.score = new ArrayList<Round>();
	}
	
	Joueur(String name){
		this.name = name;
		this.score = new ArrayList<Round>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		int totalScore=0;
		for (Round r: score)
		{
			totalScore+=r.getThrow1() + r.getThrow2();
		}
		return totalScore;
	}

	public void lancer(int l1,int l2) throws RaiseException{
		if (l1+l2 > 10)
		{
			throw new RaiseException();
		}
		else
		{
			this.score.add(new Round(l1,l2));
		}
	}

}
