public class AHCollegeStudent extends AHStudent {
    String ahCollegeName;

    public AHCollegeStudent(int rollNo, String name, int[] marks, String collegeName) {
        super(rollNo, name, marks);
        this.ahCollegeName = collegeName;
    }

    @Override
    public void displayStudentInfo() {
        super.displayStudentInfo();
        System.out.println("College: " + ahCollegeName);
    }
}