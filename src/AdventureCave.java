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

    public static void main(String[] args) {
        Random randomGenerator = new Random();

        // Welcome the player to the game
        System.out.println("Welcome, traveler, to the Cave of Wonders! Adventures await!");

        // Initialize player name and level
        String playerName;
        double playerHealth = 100.0;
        String playerAnswer;

        Scanner playerInput = new Scanner(System.in);
        System.out.println( "What is your name?");
        playerName = playerInput.nextLine();

        // _________Start of Level 1_________
        System.out.println( "You are " + playerName + ", a level " + playerLevel + " adventurer.");
        System.out.println("You made it to the entrance of the cave.");
        playerLevel += 1;
        System.out.println("You leveled up. You are now level " + playerLevel);

        // Rock falling and causing damage
        double rockDamage = randomGenerator.nextInt(5);
        System.out.println("A treacherous rock ambushes you.");
        playerHealth -= rockDamage;
        System.out.println("You took " + rockDamage + " damage. You have " + playerHealth + " health remaining.");

        if( playerHealth <= 0 ){
            System.out.println("Oh no, " + playerName +" died! They were level " + playerLevel);
            System.exit(0);
        }

        // _________Start of Level 2_________

        //Room 2.1 Description
        System.out.println("You are in a cave." + "\nThere is a dark path to the left." + "\nThere is a pile of rubble to the right." + "\nWould you like to go 'left' or 'right'?");
        playerAnswer = playerInput.nextLine();    // get player's answer

        if(playerAnswer.equalsIgnoreCase("right")){
            System.out.println("You climb up the pile of rubble. It leads to a small cavern." + "\nThere is a treasure chest here. It is full of treasure.");
            levelUp();
        }
        else if(playerAnswer.equalsIgnoreCase("left")){
            System.out.println("The path gets very dark. Another cunning rock ambushes you.");
            rockDamage = 5.0;
            playerHealth -= rockDamage;
            System.out.println("You took " + rockDamage + " damage. You have " + playerHealth + " health remaining.");
            checkHealth(playerHealth, playerName, playerLevel);
            levelUp();
        }

        // Room 2.2 Description
        System.out.println("There is a small slime here. It burbles at you menacingly." + "\nWould you like to 'befriend' it, 'fight' it or 'run' away?" );
        playerAnswer = playerInput.nextLine();  // get player's answer

        if(playerAnswer.equalsIgnoreCase("befriend")){
            System.out.println("You say hello to the slime and offer it some of your food.\n" + "The slime dissolves your food. It burbles less menacingly and leads you to a magic hat." + "\nYou found a magic hat!");

            levelUp();
        }
        else if(playerAnswer.equalsIgnoreCase("fight")){
            System.out.println("You hit the slime with your sword and it dissolves.\n" + "The slime burbles angrily and sprays some acid at you.");

            rockDamage = 5.0;
            playerHealth -= rockDamage;
            System.out.println("You took " + rockDamage + " damage. You have " + playerHealth + " health remaining.");
            checkHealth(playerHealth, playerName, playerLevel);

            levelUp();
        }
        else if(playerAnswer.equalsIgnoreCase("run")){
            System.out.println("You turn tail and run. The slime does not pursue you.\n" + "You fall into a healing spring while running.");

            double healing = 3.5; // Heal the player
            playerHealth += healing;
            System.out.println("You were healed for " + healing + ". Your health is now " + playerHealth);

            levelUp();
        }

        //_________Start of Level 3_________



        // End
        System.out.println(playerName + " survived the Cave of Wonders! You made it to level "+ playerLevel);
        playerInput.close();
    }
}
