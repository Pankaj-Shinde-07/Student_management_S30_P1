package FirstProject;

import java.util.Comparator;

public class SortByPercentage implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getPercentage(), s1.getPercentage());
        // Descending order (Topper first)
        //if we use(int) then rounding off will give us wrong error
        //here Double is used for type casting to int while maintaing the right int val
    }
}