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
			totalScore+=r.getRoundScore();
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
			this.score.add(new Round(l1, l2));
			if (this.score.size() < 2)
			{
				if ((l1 + l2) < 10)
				{
					this.score.get(this.score.size() - 1).setScore();
				}
			}
			else
			{
				if (this.score.get(this.score.size() - 2).getSpare() == true)
				{
					this.score.get(this.score.size() - 2).setSpecialScore(l1);
				}
				if (this.score.size()>2) {
					if (this.score.get(this.score.size() - 3).getStrike() == true && this.score.get(this.score.size() - 2).getStrike() == true)
					{
						this.score.get(this.score.size() - 3).setSpecialScore(10+l1);
					}
				}
				if (this.score.get(this.score.size() - 2).getStrike() == true)
				{
					if (l1<10)
					{
						this.score.get(this.score.size() - 2).setSpecialScore(l1 + l2);
					}
				}
				if ((l1 + l2) < 10)
				{
					this.score.get(this.score.size() - 1).setScore();
				}
			}
		}
	}

	public Round getRound(int index)
	{
		return score.get(index);
	}

}
