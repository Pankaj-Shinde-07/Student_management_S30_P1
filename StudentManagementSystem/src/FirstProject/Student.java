package FirstProject;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
	//attributes
	private int id;
    private String name;
    private int numOfSubjects;
    private ArrayList<Integer> marks;
    private double percentage;
		
	Student(int id, String name, ArrayList<Integer> marks){
		this.id = id;
        this.name = name;
        this.marks = marks;
        this.numOfSubjects = marks.size();
        calculatePercentage();
	}
	
	private void calculatePercentage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        
        if (numOfSubjects > 0) {
            this.percentage = (double) sum / numOfSubjects;//typecasting to double
        } else {
            this.percentage = 0;
        }
    }
	
	//getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getNumOfSubjects() {
        return numOfSubjects;
    }


    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
        this.numOfSubjects = marks.size();
        calculatePercentage();
    }
		
		
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + numOfSubjects + "\t\t"  + String.format("%.2f", percentage);
		}
	
}
