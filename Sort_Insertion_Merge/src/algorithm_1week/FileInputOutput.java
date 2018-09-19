package algorithm_1week;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileInputOutput {
	FileInputOutput(File file){
		this.file = file;
	}
	
	File file;
	int fileCheck = 0;
	int size = 0;
	int[] array = new int[100];
	int[] resizeArray;
	
	int[] readFile() {
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
		System.arraycopy(array, 0, resizeArray, 0, size+1);
		
		return resizeArray;
	}
	
	boolean fileOutput() {
		file.setWritable(true);
		try {
			FileWriter fileWriter = new FileWriter("C:/Users/ciyeh/Desktop/3학년/알고리즘/실습/data02_sort.txt");
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
		return true;
	}
}
