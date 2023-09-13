public class LectureCourseException extends Exception {
	private static final long serialVersionUID = 1L;
    private final String fieldName;

    public LectureCourseException(String fieldName) {
        super("an argument has null or illegal value");
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
