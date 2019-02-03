package simpleoop.battlingfighters;

import java.util.Random;

public class Fighter {
    private final String name;
    private String type;
    private final int skill;
    private int stamina;
    private final int DAMAGE_PTS = 2;

    public Fighter(String name, String type, int skill, int stamina) {
        assert (skill >= 1 && skill <= 18);
        assert (stamina >= 1 &&  stamina <= 24);
        this.name = name;
        this.type = type;
        this.skill = skill;
        this.stamina = stamina;
    }

    public void takeDamage(int damage) {
        if (stamina > 0) {
            stamina -= damage;
        } else {
            stamina = 0;
        }
    }

    public int calculateDamage() {
        return DAMAGE_PTS;
    }

    public int calculateAttackScore() {
        int DICE_NUM = 6;
        Random randomGenerator = new Random();
        int diceNum1 = randomGenerator.nextInt(DICE_NUM + 1);
        int diceNum2 = randomGenerator.nextInt(DICE_NUM + 1);
        return diceNum1 + diceNum2 + skill;
    }

    public boolean isDead() {
        return (stamina == 0);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSkill() {
        return skill;
    }

    public int getStamina() {
        return stamina;
    }
}
