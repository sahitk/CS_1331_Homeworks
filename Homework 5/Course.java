//I worked on the homework assignment alone, using only course materials.
/**
class that manages Course objects.
@author Sahit Kavukuntla
@version 1.0
*/
public class Course {
    private String name;
    private int level;
    private String major;
    private boolean availability;

    /**
    Constructor for Course objects.
    @param inName name of course
    @param inLevel level of course
    @param inMajor prefix of course, represents major
    @param inAvail whether or not seats are available in the course
    */
    public Course(String inName, int inLevel, String inMajor, boolean inAvail) {
        name = inName;
        level = inLevel;
        major = inMajor;
        availability = inAvail;
    }

    /**
    name getter.
    @return String name
    */
    public String getName() {
        return name;
    }
    /**
    name setter.
    @param inName name
    */
    public void setName(String inName) {
        name = inName;
    }

    /**
    level getter.
    @return int level
    */
    public int getLevel() {
        return level;
    }
    /**
    level setter.
    @param inLevel level
    */
    public void setLevel(int inLevel) {
        level = inLevel;
    }

    /**
    major getter.
    @return String major
    */
    public String getMajor() {
        return major;
    }
    /**
    major setter.
    @param inMajor major
    */
    public void setMajor(String inMajor) {
        major = inMajor;
    }

    /**
    availiability getter.
    @return boolean availability
    */
    public boolean getAvailability() {
        return availability;
    }
    /**
    availability setter.
    @param inAvail availability
    */
    public void setAvailability(boolean inAvail) {
        availability = inAvail;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Course)) {
            return false;
        }
        Course c = (Course) obj;
        return name.equals(c.getName())
            && level == c.getLevel()
            && major.equals(c.getMajor());
            //&& availability == c.getAvailability();
    }

    @Override
    public int hashCode() {
        return 0;
    }
}