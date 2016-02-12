/**
 * Created by croustibaie on 2/5/16.
 */
public class Round {
    private int throw1;
    private int throw2;
    private int score;
    private boolean spare;
    private boolean strike;


    public Round(int throw1, int throw2) {
        this.throw1 = throw1;
        this.throw2=throw2;
        if ((throw1+throw2)==10)
        {
            if (throw2>0)
            {
                this.spare=true;
                this.strike=false;
            }
            else
            {
                this.spare=false;
                this.strike=true;
            }
        }
        else
        {
            this.spare=false;
            this.strike=false;
        }
    }

    public int getThrow2() {
        return throw2;
    }

    public int getThrow1() {
        return throw1;
    }

    public void setScore()
    {
        score=throw1+throw2;
    }


    public void setSpecialScore(int scoreNextRound)
    {
        score=throw1+throw2+scoreNextRound;
    }

    public int getRoundScore()
    {
        return score;
    }

    public boolean getSpare()
    {
        return  this.spare;
    }

    public boolean getStrike()
    {
        return this.strike;
    }


}
