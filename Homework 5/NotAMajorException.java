/**
class that creates an unchecked NotAMajor exception.
@author Sahit Kavukuntla
@version 1.0
*/
public class NotAMajorException extends RuntimeException {

    /**
    constructor for exception.
    */
    public NotAMajorException() {
        super("That is not a major we know!");
    }
}