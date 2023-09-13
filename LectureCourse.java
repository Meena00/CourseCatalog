import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;

import java.util.List;
import java.util.Set;
import java.util.Arrays;

public abstract class LectureCourse extends Course  {

    private final String instructor;
    private final int credit;
    private final Set<MeetDay> meetDays;
    private final List<String> gtas;

    public LectureCourse(String crn, String title, Collection<String> levels, String instructor, int credit,
                         Collection<MeetDay> meetDays, List<String> gtas) {
        super(crn, title, levels);
        this.instructor = instructor;
        this.credit = credit;
        this.meetDays = Collections.unmodifiableSet(EnumSet.copyOf(meetDays));
        this.gtas = Collections.unmodifiableList(gtas);
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCredit() {
        return credit;
    }

    public Set<MeetDay> getMeetDays() {
        return meetDays;
    }

    public List<String> getGtas() {
        return gtas;
    }

    @Override
    public String toString() {
        return String.format("instructor: %s, credit: %d, meetDays: %s, gtas: %s, %s",
                             instructor, credit, Arrays.deepToString(meetDays.toArray()),
                             Arrays.deepToString(gtas.toArray()), super.toString());
    }

    
    public int compareTo(LectureCourse other) {
        int compareType = this.getClass().getName().compareTo(other.getClass().getName());
        if (compareType != 0) {
            return compareType;
        }
        if (this instanceof InPersonCourse) {
            InPersonCourse thisCourse = (InPersonCourse) this;
            if (other instanceof InPersonCourse) {
                InPersonCourse otherCourse = (InPersonCourse) other;
                int compareCredit = Integer.compare(thisCourse.getCredit(), otherCourse.getCredit());
                if (compareCredit != 0) {
                    return compareCredit;
                }
                return thisCourse.getTitle().compareTo(otherCourse.getTitle());
            } else if (other instanceof HybridCourse) {
                return -1;
            } else {
                return 1;
            }
        } else if (this instanceof HybridCourse) {
            HybridCourse thisCourse = (HybridCourse) this;
            if (other instanceof HybridCourse) {
                HybridCourse otherCourse = (HybridCourse) other;
                int compareTitle = thisCourse.getTitle().compareTo(otherCourse.getTitle());
                if (compareTitle != 0) {
                    return compareTitle;
                }
                return Integer.compare(thisCourse.getCredit(), otherCourse.getCredit());
            } else if (other instanceof InPersonCourse) {
                return 1;
            } else {
                return -1;
            }
        } else {
            OnlineCourse thisCourse = (OnlineCourse) this;
            if (other instanceof OnlineCourse) {
                OnlineCourse otherCourse = (OnlineCourse) other;
                int compareTitle = thisCourse.getTitle().compareTo(otherCourse.getTitle());
                if (compareTitle != 0) {
                    return compareTitle;
                }
                return Integer.compare(thisCourse.getMeetDays().size(), otherCourse.getMeetDays().size());
            } else {
                return 1;
            }
        }
    }
}
