import java.util.Collection;
import java.util.List;

public class OnlineCourse extends LectureCourse {
    public OnlineCourse(String crn, String title, Collection<String> levels, String instructor, int credit, Collection<MeetDay> meetDays, List<String> gtas) {
        super(crn, title, levels, instructor, credit, meetDays, gtas);
    }

    @Override
    public String getType() {
        return "Online";
    }
}
