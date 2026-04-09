package FirstProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandler {
	
	private static final String FILE_NAME = "student.dat";
	
	public ArrayList<Student> readStudents(){
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		File file = new File(FILE_NAME);
		
		if(!file.exists() || file.length() == 0) {
			return students;
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			students = (ArrayList<Student>) ois.readObject();
		}catch(Exception e) {
			System.out.println("Error while reading file...");
		}
		
		return students;
		
	}
	
	public void writeStudents(ArrayList<Student> students) {
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
			oos.writeObject(students);
		}catch(Exception e){
			System.out.println("Error while reading file");
		}
		
	}
}
