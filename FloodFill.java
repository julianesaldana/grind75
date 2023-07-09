import java.util.HashMap;
import java.util.LinkedHashMap;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        System.out.println(floodFill(image, sr, sc, color));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // base case, if starting pixel already has new color, return image
        if (image[sr][sc] == color)
            return image;

        // helper method
        flood(image, image[sr][sc], color, sr, sc);

        return image;
    }

    public static void flood(int[][] image, int color, int newColor, int sr, int sc) {
        // checking for valid values for rows and columns, also checking for matching starting color
        if (sr < 0 || sc < 0 ||  sr >= image.length || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }

        // if passes, set to new color
        image[sr][sc] = newColor;

        // checking up/down and left/right neighbors
        int topRowNeighbour = sr - 1;
        int bottomRowNeighbour = sr + 1;
        int leftColumnNeighbour = sc - 1;
        int rightColumnNeighbour = sc + 1;

        // recursive, want to keep going till edge of image or non-matching starting color pixel
        flood(image, color, newColor, topRowNeighbour, sc );
        flood(image, color, newColor, bottomRowNeighbour, sc );
        flood(image, color, newColor, sr, leftColumnNeighbour );
        flood(image, color, newColor, sr, rightColumnNeighbour );
    }
}
