//I worked on the homework assignment alone, using only course materials.

public class Dog {

    private String name;
    private String type;
    private int age;
    private int visitCounter;

    public Dog(String inName, String inType, int inAge, int inVisit) {
        this.name = inName;
        this.type = inType;
        this.age = inAge;
        this.visitCounter = inVisit;
    }
    public Dog(String inName, String inType) {
        this(inName, inType, 3, 2);
    }

    public void setName(String inName) {
        this.name = inName;
    }
    public String getName() {
        return this.name;
    }

    public void setType(String inType) {
        this.type = inType;
    }
    public String getType() {
        return this.type;
    }

    public void setAge(int inAge) {
        if (inAge >= 0) {
            this.age = inAge;
        }
    }
    public int getAge() {
        return this.age;
    }

    public void setVisitCounter(int inVisit) {
        if (inVisit >= 0) {
            this.visitCounter = inVisit;
        }
    }
    public int getVisitCounter() {
        return this.visitCounter;
    }

    public void visitVet() {
        if (visitCounter == 0) {
            System.out.println("This is my first visit and I am a little scared!");
        } else {
            System.out.println("I have been here " + visitCounter + " times. The vet isn't that scary!");
        }
        visitCounter++;
    }

    public String toString() {
        if (visitCounter == 0) {
            return "I am a " + type + " named " + name + " and I am "
                + age + " years old. I have never visited the vet before.";
        } else {
            return "I am a " + type + " named " + name + " and I am "
                + age + " years old. I have visited the vet before " + visitCounter + " times.";
        }
    }

    public boolean equals(Dog other) {
        return other != null
            && this.getAge() == other.getAge()
            && this.name.equals(other.getName())
            && this.type.equals(other.getType())
            && this.getVisitCounter() == other.getVisitCounter()
            && this != null;
    }
}
