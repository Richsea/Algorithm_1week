package algorithm_1week;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
	public static void main(String[] args){
		int fileCheck = 0;
		int size = 0;
		int[] array = new int[100];
		int[] resizeArray;
		int[] insertionArray;
		int[] binaryInsertionArray;
		
		//���� �о����
		File file = new File("C:/Users/ciyeh/Desktop/3�г�/�˰���/�ǽ�/data02.txt");
		FileReader fileReader;
		file.setReadOnly();
		
		try {
			fileReader = new FileReader(file);
			while((fileCheck=fileReader.read()) != -1) {
				if((char)fileCheck != ',' && ((int)fileCheck > 47 && (int)fileCheck < 58)) {
					array[size] *= 10;
					array[size] += ((int)fileCheck-48);
				}else if((char)fileCheck == ',') {
					size++;
				}else{
					System.out.print("Wrong file");
					break;
				}
			}
		}catch(FileNotFoundException e){
			System.out.print(e);
		}catch(IOException e) {
			System.out.print(e);
		}
		
		resizeArray = new int[size+1];
		insertionArray = new int[size+1];
		binaryInsertionArray = new int[size+1];
		System.arraycopy(array, 0, resizeArray, 0, size+1);
		array = null;
		
		doSort(resizeArray);
		
		//���� �����
		file.setWritable(true);
		try {
			FileWriter fileWriter = new FileWriter("C:/Users/ciyeh/Desktop/3�г�/�˰���/�ǽ�/data02_sort.txt");
			for(int i = 0; i < size+1; i++) {
				String data = Integer.toString(resizeArray[i]);
				if(i != size) {
					data += ',';
				}else {
					data = Integer.toString(resizeArray[i]);
				}
				fileWriter.write(data);
			}
			fileWriter.close();
		} catch (IOException e) {
			System.out.print(e);
		}
	}
	
	static void doSort(int[] resizeArray) {
		BinaryInsertionSort binaryInsertion = new BinaryInsertionSort(resizeArray);
		binaryInsertion.compare();
		
		Insertion insertion = new Insertion(resizeArray);	//Insertion�� Ȯ���� ������ ũ�⸦ Ȯ���ϴ� ���� �߿�
		resizeArray = insertion.compare();
		/*
		BinaryInsertionSort binaryInsertion = new BinaryInsertionSort(resizeArray);
		binaryInsertion.compare();
		*/
	}
}
