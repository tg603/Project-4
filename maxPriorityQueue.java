import java.util.*;
public interface maxPriorityQueue{
	
	public void insert(int x); //inserts x into the maxPriorityQueue
	
	public int maximum(); //returns the element of the maxPriorityQueue with largest key
	
	public int extractMax(); //removes and returns the element of the maxPriorityQueue with largest key
	
	public void increaseKey(int i, int k); //increases the value of the element located at pos i to new value k, new value is not smaller than original key value

}