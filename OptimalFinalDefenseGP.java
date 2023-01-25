//package assignment2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class accomplishes Mission Exterminate
 */
public class OptimalFinalDefenseGP
{
    private ArrayList<Integer> bombWeights;

    public OptimalFinalDefenseGP(ArrayList<Integer> bombWeights) {
        this.bombWeights = bombWeights;
    }

    public ArrayList<Integer> getBombWeights() {
        return bombWeights;
    }

    /**
     *
     * @param maxNumberOfAvailableAUAVs the maximum number of available AUAVs to be loaded with bombs
     * @param maxAUAVCapacity the maximum capacity of an AUAV
     * @return the minimum number of AUAVs required using first fit approach over reversely sorted items.
     * Must return -1 if all bombs can't be loaded onto the available AUAVs
     */
    public int getMinNumberOfAUAVsToDeploy(int maxNumberOfAvailableAUAVs, int maxAUAVCapacity)
    {
        // First sort all weights in decreasing order
        // Initialize result (Count of AUAVs)
        // Create an array to store remaining space in AUAVs, there can be at most maxNumberOfAvailableAUAVs AUAVs
        // Place items one by one
    	Collections.sort(bombWeights, Collections.reverseOrder());
    	int res = 0;
    	int[] space = new int[maxNumberOfAvailableAUAVs];
    	for(int i = 0; i<space.length; i++)
    	{
    		space[i] = maxAUAVCapacity;
    	}
    	for(int i = 0; i<bombWeights.size(); i++)
    	{
    		if(bombWeights.get(i) > maxAUAVCapacity) {return -1;}
    		for(int j = 0; j < space.length; j++)
    		{
    			if(bombWeights.get(i) <= space[j])
    			{
    				space[j] -= bombWeights.get(i);
    				break;
    			}
    			if(j == space.length-1) {return -1;}
    			
    		}
    	}
    	
    	for(int i = 0; i<space.length; i++)
    	{
    		if(space[i] != maxAUAVCapacity)
    		{
    			res++;
    		}
    	}
    	return res;
    }
    public void printFinalDefenseOutcome(int maxNumberOfAvailableAUAVs, int AUAV_CAPACITY){
        int minNumberOfAUAVsToDeploy = this.getMinNumberOfAUAVsToDeploy(maxNumberOfAvailableAUAVs, AUAV_CAPACITY);
        if(minNumberOfAUAVsToDeploy!=-1) {
            System.out.println("The minimum number of AUAVs to deploy for complete extermination of the enemy army: " + minNumberOfAUAVsToDeploy);
        }
        else{
            System.out.println("We cannot load all the bombs. We are doomed.");
        }
    }
}

