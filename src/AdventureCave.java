import java.util.Random;
import java.util.Scanner;

public class AdventureCave {

    static int playerLevel = 1;

    public static void checkHealth(double health, String name, int level) {
        if(health <= 0) {
            System.out.println("Oh no, " + name + " died! They were level " + level);
            System.exit(0);
        }
    }

    public static void levelUp() {
        playerLevel += 1;
        System.out.println("You leveled up. You are now level " + playerLevel);
    }

    public static void exitSequence(String name) {
        // End of Program
        System.out.println(name + " survived the Cave of Wonders! You made it to level " + playerLevel);
        System.exit(0);
    }

    public static void main(String[] args) {
        Random randomGenerator = new Random();

        System.out.println("Welcome, traveler, to the Cave of Wonders! Adventures await!");

        // Initialize vars
        String playerName;
        double playerHealth = 100.0;
        String playerAnswer;
        double damage;
        double healing;
        boolean isValid = true;

        Scanner playerInput = new Scanner(System.in);
        System.out.println( "What is your name?");
        playerName = playerInput.nextLine();

        // _________Start of Level 1_________
        System.out.println( "You are " + playerName + ", a level " + playerLevel + " adventurer.");
        System.out.println("You made it to the entrance of the cave.");

        do {
            System.out.println("Would you like to go 'enter' or 'leave'?");
            playerAnswer = playerInput.nextLine();    // get player's answer

            if (playerAnswer.equalsIgnoreCase("enter")) {
                System.out.println("A treacherous rock ambushes you.");
                damage = randomGenerator.nextInt(10);
                playerHealth -= damage;
                System.out.println("You took " + damage + " damage. You have " + playerHealth + " health remaining.");
                checkHealth(playerHealth, playerName, playerLevel);
                levelUp();
                break;

            } else if (playerAnswer.equalsIgnoreCase("leave")) {
                System.out.println("Looks like you are not as brave as you thought you were.");
                exitSequence(playerName);
            } else {
                System.out.println("Invalid input ");
            }
        } while (isValid);


        // _________Start of Level 2_________
        do {
            System.out.println("You are in a cave." + "\nThere is a dark path to the left." + "\nThere is a pile of rubble to the right." + "\nWould you like to go 'left' or 'right'?");
            playerAnswer = playerInput.nextLine();    // get player's answer

            if (playerAnswer.equalsIgnoreCase("right")) {
                System.out.println("You climb up the pile of rubble. It leads to a small cavern." + "\nThere is a treasure chest here. It is full of treasure.");
                levelUp();
                break;

            } else if (playerAnswer.equalsIgnoreCase("left")) {
                System.out.println("The path gets very dark. Another cunning rock ambushes you.");
                damage = randomGenerator.nextInt(10);
                playerHealth -= damage;
                System.out.println("You took " + damage + " damage. You have " + playerHealth + " health remaining.");
                checkHealth(playerHealth, playerName, playerLevel);
                levelUp();
                break;
            } else {
                System.out.println("Invalid input ");
            }
        } while (isValid);


        // _________Start of Level 3_________
        do {
            System.out.println("There is a small slime here. It burbles at you menacingly." + "\nWould you like to 'befriend' it, 'fight' it or 'run' away?" );
            playerAnswer = playerInput.nextLine();  // get player's answer

            if (playerAnswer.equalsIgnoreCase("befriend")) {
                System.out.println("You say hello to the slime and offer it some of your food.\n" + "The slime dissolves your food. It burbles less menacingly and leads you to a magic hat." + "\nYou found a magic hat!");
                levelUp();
                break;
            } else if (playerAnswer.equalsIgnoreCase("fight")) {
                System.out.println("You hit the slime with your sword and it dissolves.\n" + "The slime burbles angrily and sprays some acid at you.");
                damage = randomGenerator.nextInt(10);
                playerHealth -= damage;
                System.out.println("You took " + damage + " damage. You have " + playerHealth + " health remaining.");
                checkHealth(playerHealth, playerName, playerLevel);
                levelUp();
                break;
            } else if (playerAnswer.equalsIgnoreCase("run")) {
                System.out.println("You turn tail and run. The slime does not pursue you.\n" + "You fall into a healing spring while running.");
                healing = randomGenerator.nextInt(10); // Heal the player
                playerHealth += healing;
                System.out.println("You were healed for " + healing + ". Your health is now " + playerHealth);
                levelUp();
                break;
            }
        } while(isValid);

        //_________Start of Level 4_________
        do {
            System.out.println("As you walk deeper into the cave you notice something out of the corner or your eye" + "\nWould you like to 'see' it, or 'ignore' it?");
            playerAnswer = playerInput.nextLine();  // get player's answer

            if (playerAnswer.equalsIgnoreCase("see")) {
                System.out.println("Ohh no you were attacked by a cave spider");
                damage = randomGenerator.nextInt(10);
                playerHealth -= damage;
                System.out.println("You took " + damage + " damage. You have " + playerHealth + " health remaining.");
                checkHealth(playerHealth, playerName, playerLevel);
                levelUp();
                System.out.println("You have passed through the treacherous cave");
                break;
            } else if (playerAnswer.equalsIgnoreCase("ignore")) {
                System.out.println("You see a glistening light at the end of the tunnel\n" + "You find a healing potion as you ");
                healing = randomGenerator.nextInt(10); // Heal the player
                playerHealth += healing;
                System.out.println("You were healed for " + healing + ". Your health is now " + playerHealth);
                checkHealth(playerHealth, playerName, playerLevel);
                levelUp();
                System.out.println("You have passed through the treacherous Cave of Wonders");
                break;
            }
        }while(isValid);

        exitSequence(playerName);
        playerInput.close();
    }
}