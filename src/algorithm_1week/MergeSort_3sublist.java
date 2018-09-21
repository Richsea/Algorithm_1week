package algorithm_1week;

public class MergeSort_3sublist {
	MergeSort_3sublist(int[] array){
		this.array = array;
	}
	int[] array;
	int countMerge;
	
	int[] mergeSort(int[] array, int low, int high) {
		if(array.length == 1) return array;
		
		int firstDiv = array.length / 3;
		int lowStart = low;
		int middleStart;
		if(array.length % 3 == 0) {
			middleStart = low + firstDiv;
		}else {
			middleStart = low + firstDiv+1;
		}
		
		int highStart = middleStart + (((array.length - (firstDiv+1)) / 2) + ((array.length - (firstDiv+1)) % 2));
		int[] arrayFront;
		int[] arrayMiddle;
		int[] arrayHigh;
		
		arrayFront = new int[middleStart - lowStart];
		arrayMiddle = new int[highStart - middleStart];
		arrayHigh = new int[array.length + lowStart - highStart];

		System.arraycopy(array, 0, arrayFront, 0, middleStart - lowStart);
		System.arraycopy(array, middleStart - lowStart, arrayMiddle, 0, highStart - middleStart);
		System.arraycopy(array, highStart - lowStart, arrayHigh, 0, array.length + lowStart - highStart);
		
		mergeSort(arrayFront, 0, middleStart - lowStart-1);
		mergeSort(arrayMiddle, middleStart, highStart - 1);
		if(array.length != 2) {
			mergeSort(arrayHigh, highStart, array.length + low -1);
		}
		return merge(arrayFront, arrayMiddle, arrayHigh, array);
	}
	
	int[] merge(int[] arrayFront, int[] arrayMiddle, int[] arrayHigh, int[] array) {
		int lowStart = 0;
		int middleStart = 0;
		int highStart = 0;
		int sortLocation = 0;
		countMerge ++;
		
		while(lowStart < arrayFront.length) {
			if(highStart < arrayHigh.length) {		
				if(middleStart < arrayMiddle.length) 	//high o, middle o, low o
				{
					if(arrayFront[lowStart] < arrayMiddle[middleStart] && arrayFront[lowStart] < arrayHigh[highStart]) {	
						array[sortLocation] = arrayFront[lowStart];
						lowStart++;
					}else if(arrayMiddle[middleStart] < arrayFront[lowStart] && arrayMiddle[middleStart] < arrayHigh[highStart]){
						array[sortLocation] = arrayMiddle[middleStart];
						middleStart++;
					}else {
						array[sortLocation] = arrayHigh[highStart];
						highStart++;
					}
					sortLocation++;
				}
				else 							//high o, middle x, low o
				{
					if(arrayFront[lowStart] < arrayHigh[highStart]) {
						array[sortLocation] = arrayFront[lowStart];
						lowStart++;
					}else {
						array[sortLocation] = arrayHigh[highStart];
						highStart++;
					}
					sortLocation++;
				}
			}
			else 
			{
				if(middleStart < arrayMiddle.length) {	//high x, middle o, low o
					if(arrayFront[lowStart] < arrayMiddle[middleStart]) {
						array[sortLocation] = arrayFront[lowStart];
						lowStart++;
					}else {
						array[sortLocation] = arrayMiddle[middleStart];
						middleStart++;
					}
					sortLocation++;
				}else {		//high x, middle x, low o
					for(int i = lowStart; i < arrayFront.length; i++) {
						array[sortLocation] = arrayFront[lowStart];
						lowStart++;
						sortLocation++;	
					}
				}
			}
		}
		
		
		while(middleStart < arrayMiddle.length) {
			if(highStart < arrayHigh.length) {
				if(arrayMiddle[middleStart] < arrayHigh[highStart]) {
					array[sortLocation] = arrayMiddle[middleStart];
					middleStart++;
				}else {
					array[sortLocation] = arrayHigh[highStart];
					highStart++;
				}
				sortLocation++;
			}else {
				for(int i = middleStart; i < arrayMiddle.length; i++) {
					array[sortLocation] = arrayMiddle[middleStart];
					middleStart++;
					sortLocation++;
				}
			}
		}
		while(highStart < arrayHigh.length) {
			array[sortLocation] = arrayHigh[highStart];
			sortLocation++;
			highStart++;
		}
		return array;
	}
	
	int[] doMergeSort_3sublist() {
		return mergeSort(this.array, 0, array.length);
	}
	
	int mergeCount() {
		return countMerge;
	}
}
