public class Vet {

    private String name;
    private Dog regularDog;
    private int petsSeen;
    private static int officeVisits;

    public Vet(String inName, Dog inDog, int inPets) {
        this.name = inName;
        if (regularDog == null) {
            regularDog = inDog;
        }
        this.petsSeen = inPets;
    }
    public Vet(String vetName) {
        this(vetName, null, 0);
    }
    public Vet() {
        this("James Herriot", null, 2);
    }

    public void setName(String inName) {
        this.name = inName;
    }
    public String getName() {
        return this.name;
    }

    public void setRegularDog(Dog inDoggo) {
        this.regularDog = inDoggo;
    }
    public Dog getRegularDog() {
        return this.regularDog;
    }

    public void setPetsSeen(int inNum) {
        if (inNum >= 0) {
            this.petsSeen = inNum;
        }
    }
    public int getPetsSeen() {
        return this.petsSeen;
    }

    public static void setOfficeVisits(int inVisits) {
        if (inVisits >= 0) {
            officeVisits = inVisits;
        }
    }
    public static int getOfficeVisits() {
        return officeVisits;
    }

    public void vetVisit(Dog pupper) {
        if (regularDog == null) {
            regularDog = pupper;
        }
        pupper.visitVet();
        officeVisits++;
        petsSeen++;
        System.out.println("A vet named " + this.name + " treated " + pupper.getName() + " today.");
    }

    public String toString() {
        if (regularDog == null) {
            return "Hello, I am " + this.name + " and I have worked with " + petsSeen + " pets.";
        }
        return "Hello, I am " + this.name + " and I have worked with "
            + petsSeen + " pets. I have a regular dog that comes to me named " + regularDog.getName() + ".";
    }

    public boolean equals(Vet other) {
        if(other == null) {
            return false;
        }
        return this.name.equals(other.getName())
            && (this.regularDog != null && this.regularDog.equals(other.getRegularDog()) || this.regularDog == other.getRegularDog())
            && this.getPetsSeen() == other.getPetsSeen();
    }
}