import java.util.*;

public class InPersonCourse extends LectureCourse {
    
    public InPersonCourse(String crn, String title, Collection<String> levels, String instructor, int credit,
            Collection<MeetDay> meetDays, List<String> gtas) {
        super(crn, title, levels, instructor, credit, meetDays, gtas);
    }
    
    @Override
    public String getType() {
        return "In-Person";
    }
    
    @Override
    public int compareTo(Course other) {
        if (!(other instanceof InPersonCourse)) {
            return super.compareTo(other);
        }
        InPersonCourse otherInPerson = (InPersonCourse) other;
        return this.getCrn().compareTo(otherInPerson.getCrn());
    }
}
