package tp1;

/**
 * @author francoise.perrin
 * inspiration EPFL
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import tp1.Civilite;
import tp1.HommePolitique;



/**
 * Classe pour tester la simulation
 */

public class Election {

	public static void main(String args[]) {

		Scrutin scrutin;
		int dateSrutin;	
		int population;
		int votants;
		int dateBulletin;
		List< HommePolitique> hommePolitiques;
		List<Candidat> candidattriecroissant;
		List<Candidat> candidattriedecroissant;
		List<Candidat> listeclone;
		hommePolitiques = new ArrayList< HommePolitique>();
		hommePolitiques.add(new HommePolitique(Civilite.HOMME, "Tarek Oxlama", "parti1"));
		hommePolitiques.add(new HommePolitique(Civilite.HOMME,"Nicolai Tarcozi", "parti2"));
		hommePolitiques.add(new HommePolitique(Civilite.HOMME,"Vlad Imirboutine", "parti3"));
		hommePolitiques.add(new HommePolitique(Civilite.FEMME,"Angel Anerckjel", "parti4"));
		
		scrutin = null;
		dateSrutin = 15;		
		population = 30;
		votants = 20;

		/**
		 * simulation de votes 
		 * - tous sont envoyï¿½s ï¿½ la mï¿½me date 
		 * - Tous passent le check de date
		 * - 1 bulletins papier sur 2 passe check signature
		 */				
		System.out.println("\n\t1ere simulation \n" );
		dateBulletin = 13;	
		// simulation votes
		scrutin = simulerVotes(hommePolitiques, votants, dateSrutin, dateBulletin, population);
		// Traitement aprï¿½s vote
		scrutin.countTheVotes();
		// Affichage rï¿½sultat brut du scrutin
		//System.out.println(scrutin);
		
		//System.out.println("");

		
		
		
		/**
		 * simulation de votes 
		 * - tous sont envoyï¿½s ï¿½ la mï¿½me date invalide
		 * - Seuls les bulletins papier passent le check
		 * - 1 bulletins papier sur 2 passe check signature
		 */		
		//System.out.println("\n\t2eme simulation \n" );
		//dateBulletin = 16;		
		// simulation votes
		//scrutin = simulerVotes(hommePolitiques, votants, dateSrutin, dateBulletin, population);	
		// Traitement aprï¿½s vote
		//scrutin.countTheVotes();
		// Affichage rï¿½sultat brut du scrutin
		//System.out.println(scrutin);
	
		
		candidattriecroissant = scrutin.resultatScrutin();
		candidattriedecroissant = scrutin.resultatScrutin();
		
		Collections.sort(candidattriecroissant, new ComparateurCandidat());
		System.out.println("\n\tTrie croissant \n" );
		System.out.println(candidattriecroissant);
		
		System.out.println("\n\tTrie decroissant \n" );
		Comparator cmp = Collections.reverseOrder(new ComparateurCandidat());
		Collections.sort(candidattriedecroissant,cmp);
		System.out.println(candidattriedecroissant);
		System.out.println("\n\tMeilleur Resultat \n" );
		System.out.println(candidattriedecroissant.get(0));
		System.out.println("\n\tMeilleur Resulat V2\n");
		Candidat candidatGagnant = Collections.max(candidattriedecroissant,new ComparateurCandidat());
		System.out.println(candidatGagnant);

		
		
		//Question2
		List<Candidat> listCandidats = scrutin.resultatScrutin();
		System.out.println("\nCandidat en 2eme position");
		System.out.println(listCandidats.get(1));
		
		System.out.println("\nPosition du meilleur candidat");
		Candidat gagnant = Collections.max(listCandidats, new ComparateurCandidat());
		int index = listCandidats.indexOf(gagnant);
		System.out.println("Le candidat se trouve à l'indice: "+ index);
		
		List<Candidat> listClone = (List<Candidat>) ((ArrayList<Candidat>) listCandidats).clone();
		System.out.println("\nListe initiale:");
		System.out.println(listCandidats);
		System.out.println("Liste clonee:");
		System.out.println(listClone);
		
		//Suppression des candidats de -20%
		for(Candidat monCandidat : listCandidats) // pourquoi on px pas prendre listClone
		{
			if(monCandidat.getPourCentVoix() < 20)
				listClone.remove(monCandidat);
		}
		
		System.out.println("\nListe clonee apres suppression <20%:");
		System.out.println(listClone);
		
		listClone = (List<Candidat>) ((ArrayList<Candidat>) listCandidats).clone(); // on remet comme precedemment 
		Iterator ite = listCandidats.iterator();
		while(ite.hasNext())
		{
			Candidat monCandidat = (Candidat) ite.next();
			if(monCandidat.getPourCentVoix() < 20)
				listClone.remove(monCandidat);
		}
		System.out.println("Liste clonee apres suppression <20%:");
		System.out.println(listClone);
		
		
		listCandidats.retainAll(listClone); // ne garde que les objets idem que paramètre
		System.out.println("\nListe initiale apres suppression:");
		System.out.println(listCandidats);
		
		//Verification que les 2 listes contiennent les mêmes élements
		if(listCandidats.containsAll(listClone) && (listCandidats.size() == listClone.size()) )
		{
			System.out.println("Les 2 listes sont identiques (1ere methode)");
		}
		
		if(listCandidats.equals(listClone))
		{
			System.out.println("Les 2 listes sont identiques (2eme methode)");
		}
		
		listClone.removeAll(listClone);
		System.out.println("Liste clonee apres suppression totale");
		System.out.println(listClone);
		
		if(listClone.size() == 0)
			System.out.println("La liste clonée est bien vide (1ere methode)");
		
		if(listClone.isEmpty())
			System.out.println("La liste clonée est bien vide (2eme methode)");
		
		
	}


	private static Scrutin simulerVotes(List< HommePolitique> hommePolitiques, int votants,
			int dateSrutin, int dateBulletin, int population) {

		Scrutin scrutin = new Scrutin(hommePolitiques, population, dateSrutin);

		// ou bien
		//		scrutin = new Scrutin(population, dateSrutin);
		//		for (HommePolitique hommePolitique : hommePolitiques )
		//			scrutin.addCandidat(hommePolitique);

		//System.out.println(scrutin);

		if (hommePolitiques!=null){
			for (int i = 0; i < votants; ++i) {

				int candNum = Utils.randomInt(hommePolitiques.size());
				Vote vote = null;

				// bulletins papiers impairs sont signï¿½s, pairs sont non signï¿½s
				boolean signature = true;
				if ((i % 2) == 0) {
					signature = false;
				}

				// simulation crï¿½ation bulletins de vote
				switch (i % 3) {
				case 0:{
					vote = new BulletinElectronique(hommePolitiques.get(candNum), dateBulletin, dateSrutin);			
					break;
				}			
				case 1:{
					vote = new BulletinPapier(hommePolitiques.get(candNum), dateBulletin, dateSrutin, signature);
					break;
				}
				case 2:{
					vote = new BulletinCourrier(hommePolitiques.get(candNum), dateBulletin, dateSrutin, signature);
				}
				default: // nothing			
				}
			//	System.out.println(vote);		// pour vï¿½rif ToString() des classes qui implï¿½mentent Vote
				scrutin.addBulletin(vote);				
			}
		}
		return scrutin;
	}
}


/**
 * Classe utilitaire
 *
 */
class Utils {

	private static final Random RANDOM = new Random();

	// initialise le gï¿½nï¿½rateur de nombres alï¿½atoires
	public static void setSeed(long seed) {
		RANDOM.setSeed(seed);
	}

	// gï¿½nï¿½re un entier entre 0 et max (max non compris)
	public static int randomInt(int max) {
		return RANDOM.nextInt(max);
	}
}