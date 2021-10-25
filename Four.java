import java.util.*;
public class Four implements maxPriorityQueue{
	//Global Variables
	static int sortedPQ[];
	static Comparable a;
	static Comparable d;
	static Comparable max;
	static int key;
	static public int HMove = 0;
	static public int HComp = 0;
	
	//Insert method
	public void insert(int x){
		HComp = 0;
		HMove = 0;
		int b = x;
		System.out.println(b);
		int c = sortedPQ.length;
		int temp[] = sortedPQ;
		HMove++;
		//System.out.println(Arrays.toString(temp));
		//System.out.println(Arrays.toString(sortedPQ));
		sortedPQ = new int[c + 1];
		c = sortedPQ.length;
		for (int i = 0; i < c - 1; i++){
			HComp++;
		//System.out.println(Arrays.toString(temp));
		//System.out.println(Arrays.toString(sortedPQ));
			sortedPQ[i] = temp[i];
		}
		c = sortedPQ.length;
		sortedPQ[c - 1] = b;
	}
	
	//maximum method
	public Comparable maximum(){
		HComp = 0;
		HMove = 0;
		int c = sortedPQ.length;
		int maximum = 0;
		//int f = sortedPQ[0];
		for(int i = 0; i < c - 1; i++){
			HComp++;
			if(sortedPQ[i] < sortedPQ[i + 1]){
				maximum = sortedPQ[i + 1];
				HMove++;
			}
			else if(sortedPQ[i] > sortedPQ[i + 1]){
				maximum = sortedPQ[i];
				HMove++;
			}
		}
		//System.out.println(maximum);
		max = maximum;
		HMove++;
		return max;

	}
	
	//extractMax()
	public Comparable extractMax(){
		HComp = 0;
		HMove = 0;
		/*
		if(max == null){
			System.out.println("null");
		}
		*/
	maximum();
	int f = 0;
	int c = sortedPQ.length;
	int temp[] = new int[c - 1];
	int b = (int) max;
	//System.out.println("Temp array" + Arrays.toString(temp));
	for(int i = 0; i < sortedPQ.length; i++){
		HComp++;
		if(sortedPQ[i] == b){
			HComp++;
			f = i;
			break;
		}
	}
	for(int i = 0; i < f; i++){
		HComp++;
		temp[i] = sortedPQ[i];
		HMove++;
	}
	key = f;
	HMove++;
	//System.out.println(f);
	HComp++;
	if(f == c - 1){
	c = temp.length;
	sortedPQ = new int [c];
	sortedPQ = temp;
	HMove++;
	return max;
		/*
		for(int i = 0; i < f; i++){
			temp[i] = sortedPQ[i];
	//System.out.println("Temp array" + Arrays.toString(temp));
		}
		*/
	}
	else{
		for(int i = f; i < temp.length; i++){
			HComp++;
		temp[i] = sortedPQ[i + 1];
		HMove++;
		}
	}
	c = temp.length;
	sortedPQ = new int [c];
	sortedPQ = temp;
	HMove++;
	return max;
	}
	
	//increaseKey()
	public void increaseKey(int i, Comparable k){
		int d = (int) k;
		if(i > d){
			throw new IllegalArgumentException("New key too small");
		}else{
			sortedPQ[i] = d;
		}
	}
	
	public static void main (String[] args){
	System.out.println("\nUnsorted array Testing: \n");
	/*
	
	Unsorted list maximum() testing
	
	*/
	sortedPQ = new int[10];
	long[] CList = new long[5000];
	long[] MList = new long[5000];
	long Msum = 0;
	long Csum = 0;
	Msum = 0;
	Csum = 0;
	
	for (int i = 0; i < 5000; i++){
		for (int index = 0; index < sortedPQ.length; index++){
			sortedPQ[index] = (int)(Math.random() * 1000 + 1);
		}
			Four sorter = new Four();
			sorter.maximum();
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
	
	/*
	
	End of unsorted array maximum() testing
	
	*/
	
	/*
	
	Start of Testing for extractMax()
	
	*/
	
	sortedPQ = new int[10];
	//long[] CList = new long[5000];
	//long[] MList = new long[5000];
	//long Msum = 0;
	//long Csum = 0;
	Msum = 0;
	Csum = 0;
	
	for (int i = 0; i < 5000; i++){
	sortedPQ = new int[10];
		for (int index = 0; index < sortedPQ.length; index++){
			sortedPQ[index] = (int)(Math.random() * 1000 + 1);
		}
			Four sorter = new Four();
			sorter.extractMax();
				CList[i] = HComp;
				MList[i] = HMove;
		}
		
	for(int i = 0; i < CList.length; i++){
		Csum = Csum + CList[i];
	}
	Cavg = (Csum / CList.length);
	for(int i = 0; i < MList.length; i++){
		Msum = Msum + MList[i];
	}
	Mavg = (Msum / MList.length);
	System.out.println("Comparison Average of " + sortedPQ.length + ": " + Cavg);
	System.out.println("Movement Average of "+ sortedPQ.length + ": " + Mavg);	
	
	/*
	
	End of Testing for extractMax()
	
	*/
	
	/*
	
	Start of testing for increaseKey()
	
	*/
	
	sortedPQ = new int[10];
	//long[] CList = new long[5000];
	//long[] MList = new long[5000];
	//long Msum = 0;
	//long Csum = 0;
	Msum = 0;
	Csum = 0;
	for (int i = 0; i < 5000; i++){
	sortedPQ = new int[10];
		for (int index = 0; index < sortedPQ.length; index++){
			sortedPQ[index] = (int)(Math.random() * 1000 + 1);
			d = (int)(Math.random() * 1000 + 1);
		}
			int m = (int) d;
			int l = (int)(Math.random() * sortedPQ.length - 1 + 1);
		while (l > m){
		d = (int)(Math.random() * 1000 + 1);
		m = (int) d;
		}
			Four sorter = new Four();
			sorter.increaseKey(l, d);
				CList[i] = HComp;
				MList[i] = HMove;
		}
		
	for(int i = 0; i < CList.length; i++){
		Csum = Csum + CList[i];
	}
	Cavg = (Csum / CList.length);
	for(int i = 0; i < MList.length; i++){
		Msum = Msum + MList[i];
	}
	Mavg = (Msum / MList.length);
	System.out.println("Comparison Average of " + sortedPQ.length + ": " + Cavg);
	System.out.println("Movement Average of "+ sortedPQ.length + ": " + Mavg);	
	
	/*
	
	End of testing for increaseKey()
	
	*/
		/*
		Four sorter = new Four();
		sortedPQ = new int[3];
		sortedPQ[0] = 2;
		sortedPQ[1] = 6;
		sortedPQ[2] = 7;
		a = 89;
		sorter.extractMax();
		System.out.println(key);
		System.out.println("After " + Arrays.toString(sortedPQ));
		//System.out.println(Arrays.toString(sortedPQ));
		sorter.insert(a);
		System.out.println(Arrays.toString(sortedPQ));
		sorter.maximum();
		System.out.println("The max of " + Arrays.toString(sortedPQ) + " is " + max);
		int b = 10;
		sorter.insert(b);
		sorter.maximum();
		System.out.println("The max of " + Arrays.toString(sortedPQ) + " is " + max);
		sorter.extractMax();
		System.out.println("After " + Arrays.toString(sortedPQ));
		b = 69;
		sorter.insert(b);
		b = -1;
		sorter.insert(b);
		b = 100;
		sorter.insert(b);
		sorter.extractMax();
		System.out.println("After " + Arrays.toString(sortedPQ));
		//sortedPQ.insert(a);
		b = 6;
		sorter.increaseKey(4,b);
		System.out.println("After " + Arrays.toString(sortedPQ));
		*/
	}
}