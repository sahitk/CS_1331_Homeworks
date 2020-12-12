import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
class that searches for availability of courses.
@author Sahit Kavukuntla
@version 1.0
*/
public class CourseDataBase {

    /**
    method that calls loaderHelper.
    @param inFile file input
    @return Course arraylist of course objects
    */
    public static ArrayList<Course> loader(File inFile) {
        ArrayList<Course> arr = new ArrayList<Course>();
        loadHelper(inFile, arr);
        return arr;
    }

    /**
    method that recursively searches for .txt files representing courses.
    @param inFile file input
    @param inArr arraylist to populate
    */
    private static void loadHelper(File inFile, ArrayList<Course> inArr) {
        if (!inFile.isDirectory()) {
            inArr.add(createCourse(inFile));
        }
        if (inFile.isDirectory()) {
            File[] contents = inFile.listFiles();
            for (File f:contents) {
                loadHelper(f, inArr);
            }
        }
    }

    /**
    calls pathHelper method.
    @param inF file input
    @param inC course to find
    @return String[] with filepath to course object
    */
    public static String[] getFilePath(File inF, Course inC) throws NotAMajorException, CourseNotFoundException {
        ArrayList<Course> courseList = loader(inF);

        boolean isMajor = false;
        boolean isCourse = false;
        for (Course c:courseList) {
            if (c.equals(inC)) {
                isCourse = true;
            }
            String major = c.getMajor();
            if (major.equals(inC.getMajor())) {
                isMajor = true;
            }
        }

        if (!isMajor) {
            throw new NotAMajorException();
        }

        if (!isCourse) {
            throw new CourseNotFoundException("Course " + inC.getName() + " was not found in the database");
        }

        String[] filePath = new String[3];

        filePath[0] = inC.getMajor();
        filePath[1] = Integer.toString(inC.getLevel());
        filePath[2] = inC.getName() + ".txt";

        return filePath;
    }

    /**
    determines if all courses are available.
    @param inFile file input
    @param inArr arraylist of courses to check availability for
    @return boolean whether or not all are available
    */
    public static boolean scheduleAvailability(File inFile, Course[] inArr) {
        ArrayList<Course> tempList = loader(inFile);

        Course[] courseList = new Course[tempList.size()];

        for (int i = 0; i < courseList.length; i++) {
            courseList[i] = tempList.get(i);
        }

        for (Course c:inArr) {
            boolean doesExist = false;
            for (Course c2:courseList) {
                if (c2.equals(c)) {
                    doesExist = true;
                    if (!c2.getAvailability()) {
                        return false;
                    }
                }
            }
            if (!doesExist) {
                return false;
            }
        }
        return true;
    }

    /**
    method that creates course objects.
    @param inFile .txt file input
    @return Course object
    */
    public static Course createCourse(File inFile) {
        String name;
        int level;
        String major;
        boolean avail;

        try {
            Scanner scan = new Scanner(inFile);
            avail = scan.nextLine().equals("AVAILABLE");
            scan.close();
        } catch (FileNotFoundException err) {
            return null;
        }

        name = inFile.getName().substring(0, inFile.getName().length() - 4);
        level = Character.getNumericValue(name.charAt(name.length() - 4)) * 1000;
        major = name.substring(0, name.length() - 4);

        Course course = new Course(name, level, major, avail);
        return course;
    }
}