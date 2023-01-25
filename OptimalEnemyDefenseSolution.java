//package assignment2;

import java.util.ArrayList;

/**
 * A class that represents the optimal solution for the defense scenario (Dynamic Programming)
 */
// FREE CODE HERE
public class OptimalEnemyDefenseSolution {
    private int maxNumberOfKilledEnemies;
    private ArrayList<Integer> hoursToFireWeaponForMaxDestruction;

    public OptimalEnemyDefenseSolution(int maxNumberOfKilledEnemies, ArrayList<Integer> hoursToFireWeaponForMaxDestruction) {
        this.maxNumberOfKilledEnemies = maxNumberOfKilledEnemies;
        this.hoursToFireWeaponForMaxDestruction = hoursToFireWeaponForMaxDestruction;
    }

    public OptimalEnemyDefenseSolution() {

    }

    public int getMaxNumberOfKilledEnemies() {
        return maxNumberOfKilledEnemies;
    }

    public ArrayList<Integer> getHoursToFireWeaponForMaxDestruction() {
        return hoursToFireWeaponForMaxDestruction;
    }

    public void printEnemyDefenseSolution(ArrayList<Integer> numberOfEnemiesArrivingPerHour){
        System.out.printf("The total number of enemies arrived: %d\n", Util.sum(numberOfEnemiesArrivingPerHour));
        System.out.printf("Maximum number of enemies killed: %d\n", this.getMaxNumberOfKilledEnemies());
        System.out.print("Hours at which the weapon should be fired: ");
        for(int i=0; i<this.getHoursToFireWeaponForMaxDestruction().size(); i++) {
            System.out.print(this.getHoursToFireWeaponForMaxDestruction().get(i));
            if(i!=this.getHoursToFireWeaponForMaxDestruction().size()-1){
                System.out.print(", ");
            }
            else{
                System.out.println();
            }
        }
        System.out.printf("The number of enemies left alive: %d\n", Util.sum(numberOfEnemiesArrivingPerHour) - this.getMaxNumberOfKilledEnemies());
    }
}

