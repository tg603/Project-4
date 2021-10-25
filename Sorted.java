import java.util.*;
public class Sorted implements maxPriorityQueue{
	//Global Variables
	static int sortedPQ[];
	static Comparable a;
	static Comparable d;
	static Comparable max;
	static int key;
	static public int HMove = 0;
	static public int HComp = 0;	
	//Insert method
	public void insert(Comparable x){
		HComp = 0;
		HMove = 0;
		int b = (int) x;
		key = 0;
		key = 0;
		//System.out.println(b);
		int c = sortedPQ.length;
		int k = 0;
		int temp[] = new int[c+1];
		HMove++;
		c = sortedPQ.length;
		//System.out.println(Arrays.toString(sortedPQ));
		for(int i = 0; k != 1 && i < c - 1; i++){
			if(sortedPQ[i] >= b ){
				temp[i] = b;
				key = i;
				k++;
			}else{
				temp[i] = sortedPQ[i];	
			}
		}
		for(int i = key; i < temp.length - 1; i++){
			temp[i + 1] = sortedPQ[i];
		}
		sortedPQ = temp;
//System.out.println("temp " + Arrays.toString(temp));
//System.out.println(key);
		sortedPQ = temp;
		
		System.out.println("Final " + Arrays.toString(sortedPQ));
	}
	
	//maximum method
	public Comparable maximum(){
		HComp = 0;
		HMove = 0;
		max = sortedPQ[sortedPQ.length - 1];
		System.out.println("SortedPQ " + Arrays.toString(sortedPQ));
		System.out.println("Max" + max);
		HMove++;
		return max;

	}
	
	//extractMax()
	public Comparable extractMax(){
	HComp = 0;
	HMove = 0;
	maximum();
	int temp[] = new int [sortedPQ.length - 1];
		for(int i = 0; i < temp.length; i++){
			temp[i] = sortedPQ[i];
		}
		max = sortedPQ[sortedPQ.length - 1];
		key = sortedPQ.length - 1;
		sortedPQ = new int[temp.length];
		sortedPQ = temp;
		System.out.println(Arrays.toString(sortedPQ));
		return max;
	}
	
	//increaseKey()
	public void increaseKey(int i, Comparable k){
		int d = (int) k;
		System.out.println("d " + d);
		System.out.println("index " + i);
		System.out.println(Arrays.toString(sortedPQ));
		if(i > d){
			throw new IllegalArgumentException("New key too small");
		}else{
			sortedPQ[i] = d;
		}
		System.out.println(Arrays.toString(sortedPQ));
		sort(sortedPQ);
		System.out.println(Arrays.toString(sortedPQ));
	}
	
	public void sort(int array[]){
	//Integer Variables
		int [] temp = new int[array.length];
		mergeSort(array, temp,  0,  array.length - 1);
	}


  //mergeSort is the private method that takes the two halves of the array,
  //puts each in the sort, then puts them into the merge to be sorted together.
	private static void mergeSort(int[] array, int[] temp, int l, int r) {
		//CMerge++;
		if(l < r) {
			int center = (l + r) / 2;
			mergeSort(array, temp, l, center);
			mergeSort(array, temp, center + 1, r);
			merge(array, temp, l, center + 1, r);
		}
	}

 //merge puts both sides together piece by piece after being sorted. This one uses the idea behind
 //Exericse 2-3.2, i.e., it copies back the leftover of one list when the other has been used up.
  private static void merge(int[] array, int[] temp, int l, int r, int rightEnd ) {
        /*leftEnd is just the right side - 1, k is another variable of l so I
        can use it to add from the temp array back to the origional.
        n is used to count through the array */
        int leftEnd = r - 1;
        int k = l;
        int n = rightEnd - l + 1;
        /*while the arrays are both not at the end,compare the int of l in array
        to the int of r array and if its less than 0 then it will add the
        l int to the temp array, otherwise it will add the r int instead. */
        while(l <= leftEnd && r <= rightEnd) {
			//CMerge++;
            if(array[l] < array[r]){
				//MMerge++;
                temp[k++] = array[l++];
				//MMerge++;
				//CMerge++;
				//CMerge++;
			}else{
				//MMerge++;
                temp[k++] = array[r++];
				//MMerge++;
				//CMerge++;
				//CMerge++;
			}
          }

        // when l has not reached its end and r has
        while(l <= leftEnd) {
			//CMerge++;
            temp[k++] = array[l++];
          }
        // when l has reached its end but r has not
        while(r <= rightEnd) {
			//CMerge++;
            temp[k++] = array[r++];
          }
        //copies the temp back into the main array to be used
        for(int i = 0; i < n; i++, rightEnd--) {
			//CMerge++;
            array[rightEnd] = temp[rightEnd];
        }
    }
	


public static void main (String[] args){
	sortedPQ = new int[10];
	long[] CList = new long[5000];
	long[] MList = new long[5000];
	long Msum = 0;
	long Csum = 0;
	System.out.println("Sorted array Testing: \n");
	/*
	
	Unsorted list maximum() testing
	
	*/
	sortedPQ = new int[10];
	Msum = 0;
	Csum = 0;
	
	for (int i = 0; i < 5000; i++){
		for (int index = 0; index < sortedPQ.length; index++){
			sortedPQ[index] = (int)(Math.random() * 1000 + 1);
		}
			Sorted merge = new Sorted();
			merge.sort(sortedPQ);
			Sorted sorter = new Sorted();
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
	
	insert()
	
	*/
	sortedPQ = new int[10];
	CList = new long[10];
	MList = new long[10];
	Msum = 0;
	Csum = 0;
	for (int i = 0; i < 10; i++){
		for (int index = 0; index < sortedPQ.length; index++){
			sortedPQ[index] = (int)(Math.random() * 10 + 1);
			d = (int)(Math.random() * 10 + 1);
		}
			Sorted merge = new Sorted();
			merge.sort(sortedPQ);
		System.out.println(Arrays.toString(sortedPQ));
		//System.out.println(d);
		System.out.println(d);
			Sorted sorter = new Sorted();
			sorter.insert(d);
			sortedPQ = new int[10];
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
	System.out.println(Arrays.toString(sortedPQ));
	System.out.println(d);
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
	CList = new long[10];
	MList = new long[10];
	
	for (int i = 0; i < 10; i++){
	sortedPQ = new int[10];
		for (int index = 0; index < sortedPQ.length; index++){
			sortedPQ[index] = (int)(Math.random() * 1000 + 1);
		}
			Sorted merge = new Sorted();
			merge.sort(sortedPQ);
			Sorted sorter = new Sorted();
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
	
	
	

	sortedPQ = new int[10];
	//long[] CList = new long[5000];
	//long[] MList = new long[5000];
	//long Msum = 0;
	//long Csum = 0;
	Msum = 0;
	Csum = 0;
	CList = new long[10];
	MList = new long[10];
	for (int i = 0; i < 10; i++){
	sortedPQ = new int[10];
		for (int index = 0; index < sortedPQ.length; index++){
			sortedPQ[index] = (int)(Math.random() * 1000 + 1);
			d = (int)(Math.random() * 1000 + 1);
		}
		//System.out.println("Before: " + Arrays.toString(sortedPQ));
			Sorted merge = new Sorted();
			merge.sort(sortedPQ);
		//System.out.println("After: " + Arrays.toString(sortedPQ));
			int m = (int) d;
			int l = (int)(Math.random() * sortedPQ.length - 1 + 1);
		while (l > m){
		d = (int)(Math.random() * 1000 + 1);
		m = (int) d;
		}
			Sorted sorter = new Sorted();
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
	}
}