/**
class that creates checked CourseNotFound exception.
@author Sahit Kavukuntla
@version 1.0
*/
public class CourseNotFoundException extends Exception {

    /**
    constructor for exception.
    @param err String error message
    */
    public CourseNotFoundException(String err) {
        super(err);
    }
}