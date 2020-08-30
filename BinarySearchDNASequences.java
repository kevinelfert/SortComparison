import java.util.ArrayList;
public class BinarySearchDNASequences
{
	//variable for time it took for program to complete tasks
	private static long timeElapsed;
	public static long run() {
		//start count here
		long startTime = System.nanoTime();
		MakeRandomDNASequences.setDNAList(1000000); //1 million
		//the database for class Comparison
		ArrayList<String> dnaList = MakeRandomDNASequences.getDNAList();
		//sort using the merge sort algorithm
		mergeSort(dnaList);
		//send the sorted list to binary search algorithm 
		binarySearch(dnaList, "CAGT", 0, dnaList.size());
		//end count here
		long endTime = System.nanoTime();
		//calculate time in nanoseconds
		timeElapsed = (endTime - startTime);
		return timeElapsed;
	}

	public static void mergeSort(ArrayList<String> dnaList)
	{
		if (dnaList.size()<=1)
			return;
		int middle = dnaList.size()/2;
		ArrayList<String> left = new ArrayList<String>();
		ArrayList<String> right = new ArrayList<String>();
		for (int i = 0;i<middle;i++) 
			left.add(dnaList.get(i));
		for (int j = middle;j<dnaList.size();j++)
			right.add(dnaList.get(j));
		mergeSort(left);
		mergeSort(right);
		mergeList(dnaList, right, left);
	}

	public static void mergeList(ArrayList<String> dnaList, ArrayList<String> right, ArrayList<String> left)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		while(i!=left.size() && j!=right.size())
		{
			if (left.get(i).compareTo(right.get(j)) < 0)
				dnaList.set(k++, left.get(i++));
			else
				dnaList.set(k++, right.get(j++));
		}

		while(i!=left.size())
		{
			dnaList.set(k++, left.get(i++));
		}

		while(j!=right.size())
		{
			dnaList.set(k++, right.get(j++));
		}
	}


	public static int binarySearch(ArrayList<String> dnaList, String dnaSequence, int first, int last)
	{
		try{
			int middle = first + (last-first)/2;
			if (first>last) {
				return -1;
			}
			if (dnaSequence.compareTo(dnaList.get(middle)) == 0) {
				return middle;
			}
			else if (dnaSequence.compareTo(dnaList.get(middle)) > 0) {
				return binarySearch(dnaList, dnaSequence, middle-1, last);
			}
			else{
				return binarySearch(dnaList, dnaSequence, first, middle+1);
			}
		}catch(StackOverflowError e){
			return -1;
		}
	}

	public static long getTimeElapsed()
	{
		return timeElapsed;
	}
}
