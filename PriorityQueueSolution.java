import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
class PriorityQueueSolution{
    int id;
    String name;
    double cgpa;
    
    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public double getCGPA(){
        return cgpa;
    }
    
    public int getID(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
}

class StudentComparator implements Comparator<Student> {
 
    // Method
    // Sorting in ascending order of name
    public int compare(Student a, Student b)
    {
        if(Double.compare(a.getCGPA(), b.getCGPA()) != 0){
            return Double.compare(a.getCGPA(), b.getCGPA()) * -1;
        }else if (a.getName().compareTo(b.getName())!= 0){
            return a.getName().compareTo(b.getName()) ;
        }else{
            return Integer.compare(a.getID(), b.getID()) ;
        }
        //return a.name.compareTo(b.name);
    }
}

class Priorities{
    public List<Student> getStudents(List<String> events){
        PriorityQueue<Student> queueOfStudents = new PriorityQueue<Student>(1, new StudentComparator());  
        for(String event: events){
            String[] splittedEvents = event.split(" ");
            if(splittedEvents[0].equals("ENTER")){
                Student student = new Student(Integer.valueOf(splittedEvents[3]), splittedEvents[1], Double.valueOf(splittedEvents[2]));
                queueOfStudents.add(student);
            }else{
                queueOfStudents.poll();
            }
        }
        
        ArrayList<Student> studentList = new ArrayList<Student>(queueOfStudents);
        studentList.sort(new StudentComparator());
        return studentList;
    }
    
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
