/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package be.ses;

import java.util.ArrayList;
import java.util.Arrays;
import be.ses.*;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        ArrayList<Integer> grid = new ArrayList<>(Arrays.asList(0, 0, 1, 0, 1, 1, 0, 2, 2, 0, 1, 3, 0, 1, 1, 1));
        System.out.println(CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 5) + " This should be [2,4,10]");
    }
}
