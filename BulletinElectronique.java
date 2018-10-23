package tp1;

public class BulletinElectronique extends Bulletin implements Vote,CheckDateBulletin{
	protected HommePolitique hommepolitique;
	protected int dateVote;
	protected int dateScrutin;
	
	public BulletinElectronique(HommePolitique hommepolitique, int dateVote, int dateScrutin) {
		super( hommepolitique, dateVote);
		this.hommepolitique = hommepolitique;
		this.dateVote = dateVote;
		this.dateScrutin = dateScrutin;
	}
	
	
	public boolean checkDate(int DateScrutin)
	{		
		if(DateScrutin==this.dateVote+2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean estInvalide()
	{
		if(this.checkDate(this.dateScrutin)== false )
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
	
	

	
}
