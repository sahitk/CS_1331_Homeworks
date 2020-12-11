//I worked on the homework assignment alone, using only course materials.

public class HeadTA {
    public static void giveCollabStatement(StoneType[] stones, int rows, int cols) {
        boolean isGradingPresent = false;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] == StoneType.GRADING) {
                isGradingPresent = true;
            }
        }
        if (!isGradingPresent) {
            System.out.printf("Cannot Grade");
        } else {
            System.out.printf("Snaps Fingers%n");
            boolean[][] collabStatementArray = new boolean[rows][cols];
            boolean flipFlop = false;
            for (int row = 0; row < collabStatementArray.length; row++) {
                for (int col = 0; col < collabStatementArray[row].length; col++) {
                    if (!flipFlop) {
                        collabStatementArray[row][col] = false;
                        System.out.printf("F");
                        flipFlop = !flipFlop;
                    } else {
                        collabStatementArray[row][col] = true;
                        System.out.printf("T");
                        flipFlop = !flipFlop;
                    }
                }
                System.out.printf("%n");
            }
        }
    }
    public static void main(String[] args) {
        StoneType[] myStones = new StoneType[]{StoneType.SHINY, StoneType.SMALL, StoneType.BIG, StoneType.GRADING};
        giveCollabStatement(myStones, 3, 4);
        StoneType[] noStones = new StoneType[0];
        giveCollabStatement(noStones, 5, 5);
    }
}
