import java.util.*;

public class HybridCourse extends LectureCourse {
    
    public HybridCourse(String crn, String title, Collection<String> levels, String instructor, int credit,
                        Collection<MeetDay> meetDays, List<String> gtas) {
        super(crn, title, levels, instructor, credit, meetDays, gtas);
    }
    
    @Override
    public String getType() {
        return "Hybrid";
    }
}
