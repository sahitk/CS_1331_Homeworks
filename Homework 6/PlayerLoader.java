//I worked on the homework assignment alone, using only course materials.
import java.util.ArrayList;
/**
 * Represents a class with a single method used to
 * create the ArrayList of Player objects to be used by the game.
 * @author Sahit Kavukuntla
 * @version 1.0
 */
public class PlayerLoader {
    /**
     * Initializes the Player list for the Game.
     * @return the List of initialized Player objects
     */

    class InnerClass implements GameStrategy {

        private int counter;

        private InnerClass() {
            counter = 0;
        }

        @Override
        public void handleEvent(Player player, GameEvent event, Property property) {
            counter++;
            if (counter < 20) {
                if (event == GameEvent.BUY_PROPERTY) {
                    if (Math.random() < 0.5) {
                        player.buyProperty(property);
                    }
                }
            } else if (counter >= 20) {
                if (event == GameEvent.MANAGE_HOUSES) {
                    ArrayList<Property> list = player.getProperties();
                    int randProp = (int) (Math.random() * list.size());
                    if (player.getMoney() < 500) {
                        list.get(randProp).changeHouses(-5);
                    } else if (player.getMoney() >= 1000) {
                        list.get(randProp).changeHouses(5);
                    }
                }
            }
        }
    }

    /**
    * method that loads players.
    * @return ArrayList of players
    */
    public ArrayList<Player> loadPlayers() {
        ArrayList<Player> playerList = new ArrayList<>();

        Player player1 = new Player("Wheelbarrow", (player, event, property) -> {
            if (event == GameEvent.BUY_PROPERTY) {
                player.buyProperty(property);
            }
        });

        Player player2 = new Player("Racecar", new GameStrategy() {
            @Override
            public void handleEvent(Player player, GameEvent event, Property property) {
                if (event == GameEvent.BUY_PROPERTY && player.getMoney() >= 500) {
                    player.buyProperty(property);
                }
                if (event == GameEvent.MANAGE_HOUSES) {
                    ArrayList<Property> list = player.getProperties();
                    if (player.getMoney() >= 1000) {
                        int i = list.size() - 1;
                        while (player.getMoney() >= 500 && i >= 0) {
                            list.get(i).changeHouses(1);
                            i--;
                        }
                    } else if (player.getMoney() < 500) {
                        int i = list.size() - 1;
                        while (player.getMoney() < 500 && i >= 0) {
                            list.get(i).changeHouses(-1);
                            i--;
                        }
                    }
                }
            }
        });



        Player player3 = new Player("Thimble", new InnerClass());

        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        // TODO add Player objects to playerList
        return playerList;
    }
}