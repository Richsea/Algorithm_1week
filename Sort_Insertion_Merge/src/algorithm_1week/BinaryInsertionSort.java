package algorithm_1week;

class BinaryInsertionSort {
	BinaryInsertionSort(int[] array){
		this.array = array;
		this.pivot = (low + high)/2;
	}
	int[] array;
	int pivot, low, high;
	int temp = 0;
	int nextPivot = -1;
		
	int[] compare() {
		for(int i = 1; i < array.length; i++) {
			boolean end = false;
			low = 0;
			high = i;
			temp = array[i];
			while(!end) {
				if(temp < array[pivot])
					high = pivot-1;
				else {
					low = pivot+1;
				}
				if(high < 0) {
					System.arraycopy(array, 0, array, 1, i);
					array[0] = temp;
					break;
				}
				nextPivot = (low + high) / 2;
				end = checkEnd(pivot, nextPivot);
				pivot = nextPivot;
			}
						
			if(end && pivot!=i) {
				System.arraycopy(array, pivot+1, array, pivot+2, i-pivot-1);
				array[pivot+1] = temp;
			}
		}
		return array;
	}
	
	boolean checkEnd(int pivot, int nextPivot) {
		return (pivot == nextPivot);
	}
}
