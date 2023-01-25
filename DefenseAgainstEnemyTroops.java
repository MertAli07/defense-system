//package assignment2;

import java.util.ArrayList;

/**
 * This class accomplishes Mission Nuke'm
 */
public class DefenseAgainstEnemyTroops {
    private ArrayList<Integer> numberOfEnemiesArrivingPerHour;

    public DefenseAgainstEnemyTroops(ArrayList<Integer> numberOfEnemiesArrivingPerHour){
        this.numberOfEnemiesArrivingPerHour = numberOfEnemiesArrivingPerHour;
    }

    public ArrayList<Integer> getNumberOfEnemiesArrivingPerHour() {
        return numberOfEnemiesArrivingPerHour;
    }

    private int getRechargedWeaponPower(int hoursCharging){
        return hoursCharging*hoursCharging;
    }
    
    public static int getMax(int[] inputArray)
    { 
        int maxValue = inputArray[0]; 
        for(int i=1;i < inputArray.length;i++){ 
          if(inputArray[i] > maxValue){ 
             maxValue = inputArray[i]; 
          } 
        } 
        return maxValue; 
      }

    /**
     *     Function to implement the given dynamic programming algorithm
     *     SOL(0) <- 0
     *     HOURS(0) <- [ ]
     *     For{j <- 1...N}
     *         SOL(j) <- max_{0<=i<j} [ (SOL(i) + min[ E(j), P(j − i) ] ]
     *         HOURS(j) <- [HOURS(i), j]
     *     EndFor
     *
     * @return OptimalEnemyDefenseSolution
     */
    public OptimalEnemyDefenseSolution getOptimalDefenseSolutionDP(){
        // TODO: YOUR CODE HERE
    	int n = getNumberOfEnemiesArrivingPerHour().size();
    	int[] res = new int[n+1];
    	res[0] = 0;
    	ArrayList<ArrayList<Integer>> hours = new ArrayList<ArrayList<Integer>>();
    	hours.add(new ArrayList<Integer>());
    	for(int j = 1; j<n+1; j++)
    	{
    		ArrayList<Integer> tmp = new ArrayList<Integer>();
    		int[] temp = new int[j];
    		for(int i = 0; i<j; i++)
    		{
    			temp[i] = res[i]+Math.min(getNumberOfEnemiesArrivingPerHour().get(j-1), getRechargedWeaponPower(j-i));
    		}
    		int max = getMax(temp);
    		res[j] = max;
    		for(int k = 0; k<temp.length; k++)
    		{
    			if(temp[k] == max)
    			{
    				tmp.addAll(hours.get(k));
    				tmp.add(j);
    				hours.add(tmp);
    				break;
    			}
    		}
    	}
    	OptimalEnemyDefenseSolution answer = new OptimalEnemyDefenseSolution(res[n], hours.get(n));
        return answer;
    }
}
