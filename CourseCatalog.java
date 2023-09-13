import java.util.*;

public class CourseCatalog {
    private final List<AvailableCourse<String, Course>> catalog;
    
    public CourseCatalog() {
        catalog = new ArrayList<>();
    }
    
    public void add(String crn, Course course) {
        AvailableCourse<String, Course> availableCourse = new AvailableCourse<>(crn, course);
        catalog.add(availableCourse);
    }
    
    public List<AvailableCourse<String, Course>> search(Searchable<AvailableCourse<String, Course>> searchable) {
        List<AvailableCourse<String, Course>> searchResult = new ArrayList<>();
        for (AvailableCourse<String, Course> availableCourse : catalog) {
            if (searchable.matches(availableCourse)) {
                searchResult.add(availableCourse);
            }
        }
        return searchResult;
    }
    
    public void sort() {
        Collections.sort(catalog, new Comparator<AvailableCourse<String, Course>>() {
            @Override
            public int compare(AvailableCourse<String, Course> availableCourse1, AvailableCourse<String, Course> availableCourse2) {
                Course course1 = availableCourse1.getValue();
                Course course2 = availableCourse2.getValue();
                
                if (course1 instanceof InPersonCourse) {
                    if (course2 instanceof InPersonCourse) {
                        InPersonCourse inPersonCourse1 = (InPersonCourse) course1;
                        InPersonCourse inPersonCourse2 = (InPersonCourse) course2;
                        if (inPersonCourse1.getCredit() != inPersonCourse2.getCredit()) {
                            return Integer.compare(inPersonCourse1.getCredit(), inPersonCourse2.getCredit());
                        }
                        return inPersonCourse1.getTitle().compareTo(inPersonCourse2.getTitle());
                    } else if (course2 instanceof HybridCourse) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else if (course1 instanceof HybridCourse) {
                    if (course2 instanceof HybridCourse) {
                        HybridCourse hybridCourse1 = (HybridCourse) course1;
                        HybridCourse hybridCourse2 = (HybridCourse) course2;
                        if (!hybridCourse1.getTitle().equals(hybridCourse2.getTitle())) {
                            return hybridCourse1.getTitle().compareTo(hybridCourse2.getTitle());
                        }
                        return Integer.compare(hybridCourse1.getCredit(), hybridCourse2.getCredit());
                    } else if (course2 instanceof InPersonCourse) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    if (course2 instanceof OnlineCourse) {
                        OnlineCourse onlineCourse1 = (OnlineCourse) course1;
                        OnlineCourse onlineCourse2 = (OnlineCourse) course2;
                        if (!onlineCourse1.getTitle().equals(onlineCourse2.getTitle())) {
                            return onlineCourse1.getTitle().compareTo(onlineCourse2.getTitle());
                        }
                        return Integer.compare(onlineCourse1.getMeetDays().size(), onlineCourse2.getMeetDays().size());
                    } else {
                        return 1;
                    }
                }
            }
        });
    }
}
