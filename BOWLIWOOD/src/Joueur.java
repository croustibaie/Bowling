import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Joueur {
	
	private String name;
	private List<Round> score;
	private int lastThrow;
	private boolean expectedThrow2;
	
	Joueur()
	{
		this.score = new ArrayList<Round>();
		lastThrow = 0;
		expectedThrow2 = false;
	}
	
	Joueur(String name){
		this.name = name;
		this.score = new ArrayList<Round>();
		lastThrow = 0;
		expectedThrow2 = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		int totalScore=0;
		int turn=0;
		for (Round r: score)
		{
			if (turn==10)
			{
				break;
			}
			totalScore+=r.getRoundScore();
			turn++;
		}
		return totalScore;
	}

	public void lancer(int l1,int l2) throws RaiseException{
		if ((l1+l2 > 10) && this.score.size()<10)
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
				//spare round - 1
				if (this.score.get(this.score.size() - 2).getSpare() == true)
				{
					this.score.get(this.score.size() - 2).setSpecialScore(l1);
				}
				
				//strike round - 1 & round - 2
				if (this.score.size()>2) {
					if (this.score.get(this.score.size() - 3).getStrike() == true && this.score.get(this.score.size() - 2).getStrike() == true)
					{
						this.score.get(this.score.size() - 3).setSpecialScore(10+l1);
					}
				}
				
				//strike round - 1
				if (this.score.get(this.score.size() - 2).getStrike() == true)
				{
					if (l1<10 || this.score.size()==11)
					{
						this.score.get(this.score.size() - 2).setSpecialScore(l1 + l2);
					}
					
				}
				
				//regular round
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
	

	public boolean shoot(int i) throws RaiseException {
		
		if (i>10)
		{
			throw new RaiseException();
		}

		//round <= 9
		if(this.score.size() < 9)
		{
			if (expectedThrow2==false)
			{
				if (i==10) //strike
				{
					this.lancer(10,0);
					return false;
				}
				else
				{
					expectedThrow2 = true;
					lastThrow = i;
					return true;
				}
			}
			else
			{
				this.lancer(lastThrow, i);
				expectedThrow2 = false;
				lastThrow = 0;
				return false;
			}
		}
		
		//Round 10
		if(this.score.size() == 9)
		{
			if (expectedThrow2==false)
			{
				if (i==10) //strike
				{
					this.lancer(10,0);
					return true;
				}
				else
				{
					expectedThrow2 = true;
					lastThrow = i;
					return true;
				}
			}
			else
			{
				this.lancer(lastThrow, i);
				expectedThrow2 = false;
					
				//spare in the last round
				if ((lastThrow + i) == 10)
				{
					lastThrow = 0;
					return true;
				}
				else
				{
					lastThrow = 0;
					return false;
				}
			}
		}
			
		//supplementary round
		if (this.score.size() == 10)
		{
			//spare in the round 10
			if(this.score.get(9).getSpare())
			{
				this.lancer(i,0);
				return false;
			}
				
			//strike in the round 10
			if(this.score.get(9).getStrike())
			{
				if (expectedThrow2 = false)
				{	
					lastThrow = i;
					expectedThrow2 = true;
					return true;
				}	
				else
				{
					this.lancer(lastThrow, i);
					return false;
				}
			}
		}	
		return false;
	}
}
