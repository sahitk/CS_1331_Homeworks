//I worked on the homework assignment alone, using only course materials.

public class Student {
    private final String name;
    private int gtid;
    private int classYear;
    private double gpa;
    private double diningDollar;
    private double buzzfund;

    public Student(String inName, int inGTID, int inClassYear, double inGPA, double inDiningDollar, double inBuzzFund) {
        this.name = inName;
        this.gtid = inGTID;
        if (inClassYear >= 1 && inClassYear <= 4) {
            this.classYear = inClassYear;
        } else {
            this.classYear = 1;
        }
        if (inGPA >= 0.0 && inGPA <= 4.0) {
            this.gpa = inGPA;
        } else {
            this.gpa = 4.0;
        }
        if (inDiningDollar >= 0.0) {
            this.diningDollar = inDiningDollar;
        } else {
            diningDollar = 0.0;
        }
        if (inBuzzFund >= 0.0) {
            this.buzzfund = inBuzzFund;
        } else {
            buzzfund = 0.0;
        }
    }

    public Student(String inName, int inGTID, int inClassYear) {
        this(inName, inGTID, inClassYear, 4.0, 0.0, 0.0);
    }

    public Student(String inName, double inDiningDollar, double inBuzzFund) {
        this(inName, -1, 1, 4.0, inDiningDollar, inBuzzFund);
    }

    public Student(String inName) {
        this(inName, -1, 1);
    }

    public void purchaseMeal(double cost) {
        if (cost > this.diningDollar + this.buzzfund) {
            System.out.printf("%s does not have enough funds to purchase the meal%n", this.name);
            return;
        }
        if (cost < this.diningDollar) {
            this.diningDollar -= cost;
            System.out.printf("%s has successfully purchased the meal%n", this.name);
        } else {
            cost -= this.diningDollar;
            this.diningDollar = 0.0;
            this.buzzfund -= cost;
            System.out.printf("%s has successfully purchased the meal%n", this.name);
        }
    }

    public void addDiningDollars(double diningDollarVal) {
        this.diningDollar += diningDollarVal;
    }

    public void addBuzzfund(double buzzfundVal) {
        this.buzzfund += buzzfundVal;
    }

    public void increaseClassYear() {
        if (!(this.classYear == 4)) {
            this.classYear++;
        }
    }

    public String toString() {
        double x = this.buzzfund + this.diningDollar;
        return ("Name: " + name + ", GTID: " + gtid + ", GPA: " + gpa + ", Class Year: " + classYear + ", Funds: " + x);
    }

    public boolean equals(Student other) {
        return (this.gpa == other.gpa && this.classYear == other.classYear && this.name.equals(other.name));
    }
}
