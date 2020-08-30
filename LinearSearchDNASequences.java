import java.util.ArrayList;
public class LinearSearchDNASequences{
	//variable for time it took for program to complete task
	private static long timeElapsed;
	public static long run() {
		//start count here
		long startTime = System.nanoTime();
		MakeRandomDNASequences.setDNAList(1000000); //1 million
		//the database for class Comparison
		ArrayList<String> dnaList = MakeRandomDNASequences.getDNAList();
		//send the sorted list to linear search algorithm
		linearSearch(dnaList, "CAGT");
		//end count here
		long endTime = System.nanoTime();
		//calculate time in nanoseconds
		timeElapsed = (endTime - startTime);//1000000;
		return timeElapsed;
	}

	public static int linearSearch(ArrayList<String> dnaList, String dnaSequence)
	{
		for(int i = 0;i<dnaList.size();i++)
		{
			if (dnaSequence.equals(dnaList.get(i))) {
				return i;
			}
		}
		return -1;
	}

	public static long getTimeElapsed()
	{
		return timeElapsed;
	}
}