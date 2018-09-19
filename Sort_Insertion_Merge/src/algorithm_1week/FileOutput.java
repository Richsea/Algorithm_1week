package algorithm_1week;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {
	File file = new File("C:/Users/ciyeh/Desktop/3학년/알고리즘/실습/data02.txt");
	
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
}
