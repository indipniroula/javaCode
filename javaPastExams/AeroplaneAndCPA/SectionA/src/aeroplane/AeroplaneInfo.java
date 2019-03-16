package aeroplane;

import java.util.HashSet;
import java.util.Set;

public class AeroplaneInfo {

    public static Set<Integer> emergencyRows = new HashSet<>(Set.of(1, 10 , 30));

    public static int numRows = 16;
    public static int seatsPerRow = 10;
    public static int crewRow = 1;
    public static int[] businessRowRange = {2, 15};
    public static int[] economyRowRange = {16, numRows};



}
