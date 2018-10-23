package tp1;

import java.util.ArrayList;
import java.util.Comparator;


public class ComparateurCandidat implements Comparator<Candidat>{ 

	public int compare(Candidat candidat1,Candidat candidat2)
	{
		return (new Double(candidat1.getPourCentVoix())).compareTo(candidat2.getPourCentVoix());
	}

	
	
}
