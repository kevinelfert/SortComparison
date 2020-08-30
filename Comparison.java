public class Comparison{
	public static void main(String[] args) {
		System.out.println("Binary Search");
		System.out.println("Binary Search run time: " + BinarySearchDNASequences.run() + " ns");

		System.out.println();

		System.out.println("Sorted Binary Search");
		System.out.println("Sorted Binary Search run time: " + BinarySearchDNASequenceSorted.run() + " ns");

		System.out.println();

		System.out.println("Linear Search");
		System.out.println("Linear Search run time: " + LinearSearchDNASequences.run() + " ns");
	}
}