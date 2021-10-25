import java.util.*;
public class Tester{
	static int HMove = Four.HMove;
	static int HComp = Four.HComp;
	static int sortedPQ[];
	static Comparable a;
	static Comparable d;
	static int elements;
	public Tester(int n){
		sortedPQ = new int [n];
		elements = 0;
	}
	public void insert(Comparable x){
		System.out.println("Starting Array for Insert() " + Arrays.toString(sortedPQ));
		HComp = 0;
		HMove = 0;
		int b = (int) x;
		int c = sortedPQ.length;
		int temp[] = sortedPQ;
		sortedPQ[elements++] = b;
		System.out.println("Ending Array for Insert() " + Arrays.toString(sortedPQ));
	}
	
	public static void main (String[] args){
/*
	
	Unsorted list maximum() testing
	
	*/
	//Tester(10);
	Tester sorter = new Tester(10);
	long[] CList = new long[10];
	long[] MList = new long[10];
	long Msum = 0;
	long Csum = 0;
	Msum = 0;
	Csum = 0;
	elements = 5;
	for (int i = 0; i < 10; i++){
		for (int index = 0; index < elements; index++){
			sortedPQ[index] = (int)(Math.random() * 100 + 1);
		}
			sorter.insert(d);
				CList[i] = HComp;
				MList[i] = HMove;
		}
		
	for(int i = 0; i < CList.length; i++){
		Csum = Csum + CList[i];
	}
	long Cavg = (Csum / CList.length);
	for(int i = 0; i < MList.length; i++){
		Msum = Msum + MList[i];
	}
	long Mavg = (Msum / MList.length);
	System.out.println("Comparison Average of " + sortedPQ.length + ": " + Cavg);
	System.out.println("Movement Average of "+ sortedPQ.length + ": " + Mavg);	
	}
	/*
	
	End of unsorted array maximum() testing
	
	*/
}