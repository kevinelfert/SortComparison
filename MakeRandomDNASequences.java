import java.util.ArrayList;
import java.lang.Math;
public class MakeRandomDNASequences{

	public static ArrayList<String> dnaList = new ArrayList<>(); 
	
	public static ArrayList<String> getDNAList(){
		return dnaList;
	}

	public static void setDNAList(int numberOfDNASequences)
	{
		for(int i=0; i<numberOfDNASequences;i++){
			String dnaSequence = makeRandomDNASequence();
			dnaList.add(dnaSequence);
		}
	}
	
	public static String makeRandomDNASequence()
	{
		String dna = "";
		for (int j = 0;j<4;j++) {
			int neucleotide = (int) (Math.random()*4) + 1;
			if (neucleotide==1)
				dna+="C";
			else if (neucleotide==2) 
				dna+="G";
			else if (neucleotide==3) 
				dna+="A";
			else if (neucleotide==4) 
				dna+="T";
		}
		return dna;
	}
}