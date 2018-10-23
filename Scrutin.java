package tp1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;





public class Scrutin {
	protected List <CandidatScrutin> candidatScrutin;
	protected List <Vote> votes;
	protected int nbPersonnes;
	protected int nbVotevalides;
	protected int dateScrutin;
	

	
	public Scrutin(int population, int dateScrutin)
	{
		this(null, population, dateScrutin);
		
	}
	
	public Scrutin(List <HommePolitique> hommesPolitiques , int nbPersonnes, int dateScrutin)
	{
		
		this.votes = new LinkedList<Vote>();
		this.candidatScrutin = new LinkedList<CandidatScrutin>();
		this.nbPersonnes = nbPersonnes;
		this.dateScrutin = dateScrutin;
		this.initListCandidatScrutins(hommesPolitiques);

	}
	
	private void initListCandidatScrutins(List<HommePolitique> hommesPolitiques) {
		if (hommesPolitiques != null){
			for (HommePolitique hommePolitique : hommesPolitiques ) {
				addCandidat(hommePolitique);
			}
		}
	}
	
	public void addCandidat(HommePolitique hommePolitique)
	{
		CandidatScrutin candidatScrutin = new CandidatScrutin(hommePolitique, this.getDateScrutin());
		this.candidatScrutin.add(candidatScrutin);
	}

	public void countTheVotes()
	{
		HommePolitique hommePolitique = null;
			for(Vote monVote : votes)
			{
				if(!monVote.estInvalide())
				{
					this.nbVotevalides++;
					hommePolitique = monVote.getHommepolitique();
					for (CandidatScrutin candidatScrutin : candidatScrutin)
					{
						if (candidatScrutin.containsHommePolitique(hommePolitique) && candidatScrutin.getDateScrutin() == this.getDateScrutin() ) 
						{
							candidatScrutin.addVoix();
						}
					}
				}
	
			}	
			
	}
	
	
	public void addBulletin(Vote vote)
	{
		this.votes.add(vote);
	}
	
	public String toString()
	{
		return "Resultat du Scrutin : " + this.votes.size() + " ont votées, et "
				+ this.nbVotevalides + " votes sont valides et il y a eu un taux de participation de: "
				+this.tauxdeParticipation()+"%";
	}
	
	public int getDateScrutin()
	{
		return this.dateScrutin;
	}
	
	public int getnbVotevalides()
	{
		return this.nbVotevalides;
	}
	
	public int getnbPersonnes()
	{
		return this.nbPersonnes;
	}
	
	public void setnbPersonnes(int nbPersonnes)
	{
		this.nbPersonnes = nbPersonnes;
	}
	
	public float tauxdeParticipation()
	{
		return 100*(float)this.nbVotevalides/(float)this.nbPersonnes;
	}
	
	public void afficherBulletin()
	{
		for(Vote monVote : votes)
		{
			
			System.out.println(monVote.toString());
		}
	}
	
	public ArrayList <Candidat> resultatScrutin()
	{
		ArrayList <Candidat> listCandidat = new ArrayList<Candidat>();
		Candidat candidatPassage;

		for(CandidatScrutin moncandidatScrutin : this.candidatScrutin)
		{
			candidatPassage = new Candidat(moncandidatScrutin, this.nbVotevalides);
			listCandidat.add(candidatPassage);
		}
	
		return listCandidat;
	}
	
	
	
	
}
