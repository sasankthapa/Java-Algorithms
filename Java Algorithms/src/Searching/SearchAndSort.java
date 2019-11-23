package Searching;

public class SearchAndSort<T extends Comparable<T>> {
	
	public int binarySearch(T[] array,T target) {
		int start=0;
		int end = array.length-1;
		while(start<=end) {
			int middle=start+(end-start)/2;
			if(array[middle].compareTo(target)==0) {
				return middle;
			}
			if(array[middle].compareTo(target)>0) {			//array[middle]>target
				end=middle-1;
			}else {
				start=middle+1;
			}
		}
		return -1;
	}
	
	public void quicksort(T[] array) {
		quicksort(array,0,array.length-1);
	}
	
	private void quicksort(T[] array, int low, int high) {
    	if(low<high) {
    		int pi=partition(array,low,high);
    		
    		quicksort(array,low,pi-1);
    		quicksort(array,pi+1,high);
    	}
    	return;
    }
    
    private int partition(T[] array, int low ,int high) {
    	T pivot=array[high];
    	int i=low;
    	int j=low;
    	while(j<high) {
    		if(array[j].compareTo(pivot)<0) {
    			swap(array,i,j);
    			i++;
    		}
    		j++;
    	}
    	swap(array,j,i);
    	return i;
    }
    
    private void swap(T[] array, int i, int j) {
    	T temp=array[i];
    	array[i]=array[j];
    	array[j]=temp;
    }
}
