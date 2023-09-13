import java.util.Collection;

public class CourseSearcher implements Searchable<AvailableCourse<String, Course>> {
    private Collection<String> searchTerms;

    public CourseSearcher(Collection<String> searchTerms) {
        this.searchTerms = searchTerms;
    }

    public boolean matches(AvailableCourse<String, Course> course) {
        for (String term : searchTerms) {
            if (course.getValue().toString().indexOf(term) != -1) {
                return true;
            }
        }
        return false;
    }
}
