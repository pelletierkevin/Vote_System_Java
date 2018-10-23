package tp1;

public class BulletinPapier extends Bulletin implements Vote,CheckDateBulletin,CheckSigneBulletin {
	
	protected HommePolitique hommepolitique;
	protected int dateVote;
	protected int dateScrutin;
	protected boolean Signature;

	
	public BulletinPapier(HommePolitique hommepolitique, int dateVote, int dateScrutin,boolean Signature) {
		super( hommepolitique, dateVote);//On hérite de la classe mere abstraite
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
		if( this.checkSigne()==false )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public HommePolitique getHommepolitique()
	{
		return this.hommepolitique;
	}
	

	
	public int getDateScrutin() {
		return dateScrutin;
	}
	
	
	public String toString()
	{
		return super.toString() + " Signature " + this.Signature ;
	}
	
}
