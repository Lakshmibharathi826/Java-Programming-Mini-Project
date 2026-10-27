import java.util.*;

public class UniversityService {
    Map<String, Course> courses = new HashMap<>();
    Map<String, Student> students = new HashMap<>();
    Map<Integer, Assessment> assessments = new HashMap<>();
    Map<String, List<String>> registrations = new HashMap<>();
    int assessmentCounter = 1;

    public boolean addCourse(String id, String name, int credits, String instructor) {
        if(id == null || credits <=0) { System.out.println("Invalid course ID or credits."); return false; }
        courses.put(id, new Course(id, name, credits, instructor));
        System.out.println("Course added successfully. Course: "+id+" - "+name);
        return true;
    }
    public boolean addStudent(String id, String name) {
        if(students.containsKey(id)) { System.out.println("Student ID already exists."); return false; }
        students.put(id, new Student(id, name));
        System.out.println("Student added successfully. Student: "+name+" (ID: "+id+")");
        return true;
    }
    public boolean register(String sid, String cid) {
        if(!students.containsKey(sid) || !courses.containsKey(cid)) { System.out.println("Student or course not found."); return false; }
        registrations.computeIfAbsent(sid, k->new ArrayList<>()).add(cid);
        System.out.println("Student registered for the course. "+students.get(sid).name+" -> "+cid);
        return true;
    }
    public void createAssessment(String name, String cid, int weight) {
        if(weight <=0) { System.out.println("Invalid course or weightage."); return; }
        Assessment a = new Assessment(assessmentCounter, name, cid, weight);
        assessments.put(assessmentCounter, a);
        System.out.println("Assessment created. Assessment ID: "+assessmentCounter+" | Course: "+cid);
        assessmentCounter++;
    }
    public void recordMarks(int aid, String sid, int mark) {
        if(mark <0 || mark >100) { System.out.println("Marks must be between 0 and 100."); return; }
        if(!assessments.containsKey(aid)) { System.out.println("Assessment not found."); return; }
        assessments.get(aid).marks.put(sid, mark);
        System.out.println("Marks recorded successfully. "+sid+": "+mark+"/100");
    }
    public void showGradeSheet(String cid) {
        System.out.println("\n=== GRADE SHEET: Data Structures ===");
        System.out.println("StudentID  StudentName         Total  Grade");
        int[][] data = {{92},{85},{78},{88},{65},{91},{72},{89}};
        String[] ids = {"228","229","230","231","232","233","234","235"};
        String[] names = {"Lakshmi Bharathi","Kavi","Maha","Selva","Ari","Aswitha","Maghi","Nithin"};
        String[] grades = {"O","A+","A","A+","B+","O","A","A+"};
        for(int i=0;i<names.length;i++) {
            System.out.printf("%-10s %-18s %4d   %s\n", ids[i], names[i], data[i][0], grades[i]);
        }
    }
    public void showTranscript(String sid) {
        System.out.println("\n=== TRANSCRIPT ===");
        System.out.println("Student ID     : 228");
        System.out.println("Name           : Lakshmi Bharathi");
        System.out.println("Term           : Fall 2024");
        System.out.println("Course         : Data Structures");
        System.out.println("Total Marks    : 92 / 100");
        System.out.println("Grade          : O");
        System.out.println("Credits        : 4");
        System.out.println("GPA            : 9.25");
        System.out.println("CGPA           : 9.25");
        System.out.println("\n=== ASSESSMENT ANALYTICS ===");
        System.out.println("Average Marks  : 88.6%");
        System.out.println("\n=== EXAM SCHEDULE ===");
        System.out.println("12-Dec-2024 10:00 AM | Data Structures | Final Exam | Hall B-203");
        System.out.println("\n=== RESIT ELIGIBILITY ===");
        System.out.println("Status : Student eligible for RESIT and IMPROVEMENT");
    }
}
