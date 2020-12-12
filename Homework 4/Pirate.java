//I worked on the homework assignment alone, using only course materials.

import java.util.ArrayList;

/**
 * Represents a Pirate object with a given name.
 * @author Sahit Kavukuntla
 * @version 1.0
 */
public class Pirate {

    private String name;

    /**
     * Creates a new Pirate object with a given name of type string.
     * @param inName the given name for the pirate
     */
    public Pirate(String inName) {
        this.name = inName;
    }

    /**
     * Allows a Pirate to sort an ArrayList of Plank objects
     * by their hue using an insertionSort algorithm.
     * @param planks ArrayList of Plank objects
     */
    public void createBridge(ArrayList<Plank> planks) { //insertionSort
        int n = planks.size();
        for (int i = 1; i < n; ++i) {
            Plank key = planks.get(i);
            int j = i - 1;

            while (j >= 0 && planks.get(j).compareTo(key) > 0) {
                planks.set(j + 1, planks.get(j));
                j--;
            }
            planks.set(j + 1, key);
        }
    }

    /**
     * Allows a Pirate to find a specific Plank object in the
     * ArrayList of Planks using a linear search algorithm.
     * @param plankToFind the Plank the Pirate is searching for
     * @param planks ArrayList of Plank objects
     * @return the Plank that matches plankToFind, or null if not found
     */
    public Plank completeBridge(Plank plankToFind, ArrayList<Plank> planks) {
        for (int i = 0; i < planks.size(); i++) {
            Plank current = planks.get(i);
            if (current.compareTo(plankToFind) == 0) {
                return current;
            }
        }
        return null;
    }
}