import java.util.ArrayList;

/**
 * Represents a StrongPirate object with a given name.
 * @author Sahit Kavukuntla
 * @version 1.0
 */
public class StrongPirate extends Pirate {

    /**
     * Creates a new StrongPirate object with a given name of type string.
     * @param inName the given name for the pirate
     */
    public StrongPirate(String inName) {
        super(inName);
    }

    /**
     * Allows a StrongPirate to sort an ArrayList of Plank
     * objects by their hue using a selectionSort algorithm.
     * @param planks ArrayList of Plank objects
     */
    public void createBridge(ArrayList<Plank> planks) {
        int n = planks.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (planks.get(j).compareTo(planks.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Plank temp = planks.get(minIndex);
            planks.set(minIndex, planks.get(i));
            planks.set(i, temp);
        }
    }

    /**
     * Allows a StrongPirate to find a specific Plank object in the
     * ArrayList of Planks using a binary search algorithm.
     * @param plankToFind the Plank the Pirate is searching for
     * @param planks ArrayList of Plank objects
     * @return the Plank that matches plankToFind, or null if not found
     */
    public Plank completeBridge(Plank plankToFind, ArrayList<Plank> planks) {
        int left = 0;
        int right = planks.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            Plank current = planks.get(mid);
            if (current.compareTo(plankToFind) == 0) {
                return current;
            }
            if (current.compareTo(plankToFind) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}