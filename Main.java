public class Main {

    ///////////////////////////////////////////////////////
    // End of Trimester 1 Project
    //
    // A classic tale of a hero vs a villain
    // Both are equipped with a weapon
    // Both attempt to slay the other
    //
    // What will the journey be like for our brave hero???
    ///////////////////////////////////////////////////////

    public static void main(String[] args) {
        Weapon blade = new Weapon("Blade of Destiny", "Sword", 300, 10);
        Hero pc = new Hero("Prince Charming", blade, 150, 75, new Score());

        System.out.println("Our brave hero, " + pc.getName() + " starts his journey to find Sleeping Beauty.");
        System.out.println("As he moves towards the castle to save the princess, " + pc.getName() + " encounters a rouge crow! The crow attacks!\n");

        Weapon beak = new Weapon("Crow's Beak", "Natural Attack", 100, 5);
        BadGuy crow = new BadGuy("Crow", beak, 25, 50, new Score());

        boolean isFighting = true;

        boolean enemyAttack = true;

        while(isFighting) {
            // check if hero is dead
            if (pc.isDead()) {
                System.out.println("You are dead!!!!");
                break;
            }
            // check if bad guy is dead
            if (crow.isDead()) {
                System.out.println("The crow has been slain!");
                break;
            }

            // enemy attacks if it is their turn
            if (enemyAttack) {
                System.out.println(crow.getName() + " attacks twice using " + crow.getWeapon().getName() + "!");
                for (int i = 0; i < 2; i++) {
                    int result = Dice.roll();
                    System.out.println(crow.getName() + " rolls a " + result + ".");
                    if (result >= 12) {
                        System.out.println("Attack #" + (i+1) + " connects dealing " + crow.getWeapon().getBaseDamage() + " damage.");
                        pc.setHitPoints(pc.getHitPoints() - crow.getWeapon().getBaseDamage());
                        System.out.println(pc.getName()+ ": " + pc.getHitPoints());
                    } else {
                        System.out.println("Attack #" + (i+1) + " misses... ");
                    }
                }
                enemyAttack = !enemyAttack;
            }
            else
            {
                System.out.println(pc.getName() + " attacks using " + pc.getWeapon().getName() + "!");
                int result = Dice.roll();
                System.out.println(pc.getName() + " rolls a " + result + ".");
                if (result >= 8) {
                    System.out.println("The attack connects dealing " + pc.getWeapon().getBaseDamage() + " damage.");
                    crow.setHitPoints(crow.getHitPoints() - pc.getWeapon().getBaseDamage());
                    System.out.println(crow.getName()+ ": " + crow.getHitPoints());
                } else {
                    System.out.println("The attack misses... ");
                }
                enemyAttack = !enemyAttack;
            }
        }
        System.out.println("\n" + pc.getName() + " has " + pc.getHitPoints() + " hit points remaining.");
    }
}
