/**
* This method takes a 1D Iterable and an element in the array and gives back an iterable containing the indexes of all neighbours with the same value as the specified element
*@return - Returns a 1D Iterable of ints, the Integers represent the indexes of all neighbours with the same value as the specified element on index 'indexToCheck'.
*@param grid - This is a 1D Iterable containing all elements of the grid. The elements are integers.
*@param width - Specifies the width of the grid.
*@param height - Specifies the height of the grid (extra for checking if 1D grid is complete given the specified width)
*@param indexToCheck - Specifies the index of the element which neighbours that need to be checked
*/

package be.ses;

import java.util.ArrayList;  
import java.util.List; 
import java.lang.Integer;

public class CheckNeighboursInGrid {
    public Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid,int width, int height, int indexToCheck){
    // TODO write your code below so you return the correct result
        List<Integer> result = new ArrayList<>();
        List<Integer> gridList = new ArrayList<>();
        grid.forEach(gridList::add);

        int row = indexToCheck / width;
        int col = indexToCheck % width;
        int valueToCheck = gridList.get(indexToCheck);

        // Define the relative positions of neighbors (top, bottom, left, right)
        int[][] directions = {
            {-1, 0}, // top
            {1, 0},  // bottom
            {0, -1}, // left
            {0, 1}   // right
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // Check if the neighbor is within bounds
            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width) {
                int neighborIndex = newRow * width + newCol;
                if (gridList.get(neighborIndex) == valueToCheck) {
                    result.add(neighborIndex);
                    }
        }
    }
    return result;
    }
}