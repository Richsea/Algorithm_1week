package algorithm_1week;

public class MergeSort {
	MergeSort(int[] array){
		this.array = array;
	}
	int[] array;
	int countMerge = 0;
	
	int[] mergeSort(int[] array, int low, int high) {
		if(array.length == 1) return array;
		
		int middle = (high-low) / 2;
		int[] arrayFront;
		int[] arrayBack;
		
		arrayFront = new int[middle+1];
		arrayBack = new int[array.length - (middle+1)];
		System.arraycopy(array, 0, arrayFront, 0, middle+1);
		System.arraycopy(array, middle+1, arrayBack, 0, array.length - (middle+1));

		mergeSort(arrayFront, 0, middle);
		mergeSort(arrayBack, middle+1, array.length-1);
		
		return merge(arrayFront, arrayBack, array);
	}
	int[] merge(int[] arrayFront, int[] arrayBack, int[] array) {
		int lowStart = 0, highStart = 0, sortLocation = 0;
		countMerge ++;
		
		while(lowStart < arrayFront.length) {
			if(highStart < arrayBack.length) {
				if(arrayFront[lowStart] < arrayBack[highStart]) {
					array[sortLocation] = arrayFront[lowStart];
					lowStart++;
				}else {
					array[sortLocation] = arrayBack[highStart];
					highStart++;
				}
				sortLocation++;
			}else {
				for(int i = lowStart; i < arrayFront.length; i++) {
					array[sortLocation] = arrayFront[lowStart];
					lowStart++;
					sortLocation++;
				}
			}
		}
		
		while(highStart < arrayBack.length) {
			array[sortLocation] = arrayBack[highStart];
			highStart++;
			sortLocation++;
		}
		return array;
	}
	
	int[] doMergeSort() {
		return mergeSort(this.array, 0, array.length);
	}
	
	int mergeCount() {
		return countMerge;
	}
	
}
