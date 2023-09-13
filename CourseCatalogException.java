public class CourseCatalogException extends IllegalStateException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String crn;
    private final Course course;

    public CourseCatalogException(String crn, Course course) {
        super("The course’s CRN is already in the catalog.");
        this.crn = crn;
        this.course = course;
    }

    public String getCrn() {
        return crn;
    }

    public Course getCourse() {
        return course;
    }
}
