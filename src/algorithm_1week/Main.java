package algorithm_1week;

import java.io.File;

public class Main {
	public static void main(String[] args){
		int fileCheck = 0;
		int size = 0;
		int[] array;
		int[] insertionArray;
		int[] binaryInsertionArray;
		
		File file = new File("C:/Users/ciyeh/Desktop/3학년/알고리즘/실습/data02.txt");
		
		FileInputOutput fileIO = new FileInputOutput(file);
		array = fileIO.readFile();
		size = array.length;
		
		insertionArray = new int[size+1];
		binaryInsertionArray = new int[size+1];
		
		doSort(array);
		
		fileIO.fileOutput();
	}
	
	static void doSort(int[] array) {
		BinaryInsertionSort binaryInsertion = new BinaryInsertionSort(array);
		binaryInsertion.compare();
		
		Insertion insertion = new Insertion(array);	//Insertion이 확인할 파일의 크기를 확인하는 것이 중요
		array = insertion.compare();
		/*
		BinaryInsertionSort binaryInsertion = new BinaryInsertionSort(resizeArray);
		binaryInsertion.compare();
		*/
	}
}
