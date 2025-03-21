package be.ses;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CheckNeighboursTest {

    @Test
    void testSingleMatchingNeighbour() {
        List<Integer> grid = List.of(
            1, 2, 3,
            4, 1, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4; // Value is 1
        List<Integer> result = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
        assertEquals(List.of(0), result); // Only the top neighbor matches
    }

    @Test
    void testMultipleMatchingNeighbours() {
        List<Integer> grid = List.of(
            1, 1, 1,
            1, 1, 1,
            1, 1, 1
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4; // Value is 1
        List<Integer> result = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
        assertEquals(List.of(1, 3, 5, 7), result); // All neighbors match
    }

    @Test
    void testNoMatchingNeighbours() {
        List<Integer> grid = List.of(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4; // Value is 5
        List<Integer> result = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
        assertTrue(result.isEmpty()); // No neighbors match
    }

    @Test
    void testCornerCaseTopLeft() {
        List<Integer> grid = List.of(
            1, 2, 3,
            4, 1, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 0; // Top-left corner, value is 1
        List<Integer> result = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
        assertEquals(List.of(4), result); // Only bottom neighbor matches
    }

    @Test
    void testCornerCaseBottomRight() {
        List<Integer> grid = List.of(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 8; // Bottom-right corner, value is 9
        List<Integer> result = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
        assertTrue(result.isEmpty()); // No neighbors match
    }

    @Test
    void testEdgeCaseMiddleOfEdge() {
        List<Integer> grid = List.of(
            1, 2, 1,
            4, 1, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 1; // Middle of the top edge, value is 2
        List<Integer> result = (List<Integer>) CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
        assertTrue(result.isEmpty()); // No neighbors match
    }
}