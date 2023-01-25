//package assignment2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.*;

/**
 * A class that contains some useful functions that might be of use
 */
// FREE CODE HERE
public class Util {
    public static final int DEFAULT_MAX_LINES = 80;
    public static final char DEFAULT_SYMBOL = '-';

    public static void printlnDash(int limit, char symbol) {
        for (int i = 0; i < limit; i++) System.out.print(symbol);
        System.out.println();
    }
    public static String addLinebreaks(String input, int maxLineLength) {
        String regex = String.format(".{1,%d}", maxLineLength);
        Matcher m = Pattern.compile(regex).matcher(input);
        ArrayList<String> lines = new ArrayList<>();
        while (m.find()) {
            lines.add(m.group());
        }
        return String.join("\n", lines);
    }

    public static String addLinebreaks(String input) {
        return addLinebreaks(input, DEFAULT_MAX_LINES);
    }

    public static void printlnDash() {
        printlnDash(DEFAULT_MAX_LINES, DEFAULT_SYMBOL);
    }

    public static int sum(ArrayList<Integer> numbers) {
        int total = 0;
        for (int i = 0; i < numbers.size(); i++) {
            total+=numbers.get(i);
        }
        return total;
    }

    public static ArrayList<Integer> readTroopsDeploymentSchedule(String filename){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        Scanner s = null;
        try {
            s = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNext()) {
            integers.add(s.nextInt());
        }
        s.close();
        return integers;
    }

    public static int readNumberOfAvailableAUAVs(String filename){
        int number;
        Scanner s = null;
        try {
            s = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        number = s.nextInt();
        s.close();
        return number;
    }

    public static ArrayList<Integer> readBombWeights(String filename){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        Scanner s = null;
        try {
            s = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        s.nextInt(); // skip first integer
        while (s.hasNext()) {
            integers.add(s.nextInt());
        }
        s.close();
        return integers;
    }
}

