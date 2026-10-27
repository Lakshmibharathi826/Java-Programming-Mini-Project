import java.util.*;

class Course {
    String id, name, instructor;
    int credits;
    Course(String id, String name, int credits, String instructor) {
        this.id = id; this.name = name; this.credits = credits; this.instructor = instructor;
    }
}
class Student {
    String id, name;
    Student(String id, String name) { this.id = id; this.name = name; }
}
class Assessment {
    int id; String name, courseId; int weightage;
    String examDate = "12-Dec-2024 10:00 AM";
    String hall = "Hall B-203";
    Map<String, Integer> marks = new HashMap<>();
    Assessment(int id, String name, String courseId, int weightage) {
        this.id = id; this.name = name; this.courseId = courseId; this.weightage = weightage;
    }
}
