package tp1;

public class BulletinCourrier extends Bulletin implements Vote,CheckDateBulletin,CheckSigneBulletin{
	protected HommePolitique hommepolitique;
	protected int dateVote;
	protected int dateScrutin;
	protected boolean Signature;
	
	public BulletinCourrier(HommePolitique hommepolitique, int dateVote, int dateScrutin,boolean Signature){
		super(hommepolitique, dateVote);
		this.hommepolitique = hommepolitique;
		this.dateVote = dateVote;
		this.dateScrutin = dateScrutin;
		this.Signature = Signature;
	}
	
	
	
	public boolean checkDate(int DateScrutin)
	{
		if(DateScrutin>=this.dateVote)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean checkSigne()
	{
		return this.Signature;
	}
	
	public boolean estInvalide()
	{
		if(this.checkDate(this.dateScrutin)== false || this.checkSigne()==false )
		{
			return true;
		}
		else
		{
			return false;
		}
	}



	public int getDateScrutin() {
		return dateScrutin;
	}
	

	public boolean isSignature() {
		return Signature;
	}
	
	public String toString()
	{
		return super.toString() + " Signature " + this.Signature ;
	}

}
