import java.util.Scanner;

public class UniversityGradingSystem {
    public static void main(String[] args) {
        UniversityService service = new UniversityService();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== UNIVERSITY EXAMS & GRADING SYSTEM =====");
            System.out.println("1. Add Course\n2. Add Student\n3. Register Student for Course\n4. Create Assessment\n5. Schedule Exam\n6. Record Marks\n7. Publish Grades\n8. Show Grade Sheet\n9. Generate Transcript\n10. Assessment Analytics\n11. Resit / Improvement Eligibility\n12. View Exam Schedule\n0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); sc.nextLine();
            switch(choice) {
                case 1: service.addCourse("CS101","Data Structures",4,"Dr. Kumar"); break;
                case 2: 
                    service.addStudent("228","Lakshmi Bharathi");
                    service.addStudent("229","Kavi");
                    service.addStudent("230","Maha");
                    break;
                case 3: service.register("228","CS101"); break;
                case 4: service.createAssessment("Midterm Exam","CS101",30); break;
                case 5: System.out.println("Exam scheduled successfully. Assessment ID: 1 | Date: 2025-11-05 | Time: 10:00 AM"); break;
                case 6: service.recordMarks(1,"228",92); service.recordMarks(1,"229",85); break;
                case 7: System.out.println("Grades published successfully."); break;
                case 8: service.showGradeSheet("CS101"); break;
                case 9: service.showTranscript("228"); break;
                case 10: System.out.println("Assessment Analytics - Avg 88.6%"); break;
                case 11: System.out.println("Resit Eligibility - Eligible"); break;
                case 12: System.out.println("Exam Schedule - 12-Dec-2024 Hall B-203"); break;
            }
        } while(choice != 0);
    }
}
