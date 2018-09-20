package algorithm_1week;

class Insertion {
	Insertion(int[] array){
		this.array = array;
	}
	int[] array;
	int currentLocation = 1;
	
	int[] compare() {
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			for(int j = 0; j < i; j++) {
				if(temp < array[j]) {
					System.arraycopy(array, j, array, j+1, i-j);
					array[j] = temp;
					currentLocation++;
					break;
				}
			}
		}
		return array;
	}
}
