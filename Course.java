import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class Course implements Comparable<Course> {


    protected final String crn;
    protected final String title;
    protected final Collection<String> levels;

    public Course(String crn, String title, Collection<String> levels) {
        if (title.length() < 15 || title.length() > 40) {
            throw new IllegalArgumentException("Title must be between 15 and 40 characters long.");
        }
        if (levels.isEmpty()) {
            throw new IllegalArgumentException("At least one level must be provided.");
        }
        if (levels.size() != new HashSet<>(levels).size()) {
            throw new IllegalArgumentException("Level strings must be unique.");
        }
        this.crn = crn;
        this.title = title;
        this.levels = new ArrayList<>(levels);
    }

    public String getCrn() {
        return crn;
    }

    public String getTitle() {
        return title;
    }

    public Collection<String> getLevels() {
        return Collections.unmodifiableCollection(levels);
    }

    public abstract String getType();

    @Override
    public int compareTo(InPersonCourse other) {
        return this.getCrn().compareTo(other.getCrn());
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course other = (Course) obj;
            return this.crn.equals(other.crn);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("type: %s, CRN: %s, title: %s, levels: %s",
                getType(), crn, title, Arrays.deepToString(levels.toArray()));
    }
}
