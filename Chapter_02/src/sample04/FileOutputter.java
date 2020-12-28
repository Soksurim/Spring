package sample04;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath, fileName;
	
	public FileOutputter() {
		System.out.println("2. FileOutputter() 기본생성자 하는게 없는놈");
	}

	public void setFilePath(String filePath) {
		System.out.println("3. setFilePath(String filePath)");
		this.filePath = filePath;
	}
	public void setFileName(String fileName) {
		System.out.println("4. setFileName(String fileName)");
		this.fileName = fileName;
	}
	
	@Override
	public void output(String message) {
		try {
			System.out.println("f1");
			FileWriter fileWriter = new FileWriter(filePath+fileName);
			System.out.println("f2");
			
			fileWriter.write(message);
			System.out.println("f3");
			fileWriter.close();
			System.out.println("f4");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}