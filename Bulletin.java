package tp1;

public abstract class Bulletin implements Vote {
	//On definit une classe abstraite car elle implemente à moitié l interface vote
	protected HommePolitique hommepolitique;
	protected int dateVote;
	
public Bulletin(HommePolitique hommepolitique, int dateVote){
	
		this.hommepolitique = hommepolitique;
		this.dateVote = dateVote;;
	}


	public HommePolitique getHommepolitique()
	{
		return this.hommepolitique;
	}
	
	public int getDate()
	{
		return this.dateVote;
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + this.hommepolitique.toString()
				+ "Date du vote : " + this.getDate();
	}
	
}
