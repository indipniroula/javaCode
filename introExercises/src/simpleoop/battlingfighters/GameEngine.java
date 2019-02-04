package simpleoop.battlingfighters;


// To improve this: think of a toString method for a fighters stats
// GameEngine - its own isolated class
// Main Class - where the game playing should happen.
// Can simplify S.O.printLn using an alias function
// Declare winners and losers as new Fighters - can simplify code
// Try to encapsulate as much as possible

public class GameEngine {

    public static void main(String[] args) {

        Fighter first = new Fighter("Joe", "Warrior", 18, 11);
        Fighter second = new Fighter("Alex", "Warrior", 18, 12);
        Fighter[] fighters = {first, second};

        //Introduction
        System.out.println("At start of battle, stats are: ");
        introduceStats(fighters);
        System.out.println("- - - - - - - - - -");

        //Battle
        while (!first.isDead() && !second.isDead()) {
            simulateBattle(first, second);
        }

        //
        //Announce Winner
        for(Fighter fighter: fighters) {
            if (fighter.isDead()) {
                continue;
            } else {
                System.out.println("End of battle, " +
                        fighter.getName() + " - " + fighter.getType() +
                        " - skill: " + fighter.getSkill() + "; stamina: " +
                        fighter.getStamina() + " wins!");
                System.exit(0);
            }
        }

    }

    public static void simulateBattle(Fighter first, Fighter second) {

        Fighter[] fighters = {first, second};
        int firstFighterScore = first.calculateAttackScore();
        int secondFighterScore = second.calculateAttackScore();

        //Battle
        if (firstFighterScore == secondFighterScore) {
            System.out.println(first.getName() + " draws with " + second.getName());
            System.out.println("- - - - - - - - - -");
        }

        if (firstFighterScore > secondFighterScore) {
            System.out.println(first.getName() + " hits " + second.getName() + " stats:");
            second.takeDamage(second.calculateDamage());
        } else {
            System.out.println(second.getName() + " hits " + first.getName() + " stats:");
            first.takeDamage(first.calculateDamage());
        }

        // Stats after battle
        introduceStats(fighters);
        System.out.println("- - - - - - - - - -");

    }

    private static void introduceStats(Fighter[] fighters) {
        for (Fighter fighter : fighters) {
            System.out.print(fighter.getName() + " - " + fighter.getType() + " - ");
            System.out.print("skill: " + fighter.getSkill() + "; ");
            System.out.println("stamina: " + fighter.getStamina());
        }
    }
}
