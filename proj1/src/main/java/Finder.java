public class Finder {

    public Finder() { }

    // function to get array
    public int[] getArray() {
        int[] arr = {1, 2}; // === EDIT THIS ARRAY ===
        return arr;
    }

    // finds the max number inside of an array
    public Integer findMax(int[] intArray){
        if (intArray == null || intArray.length == 0) { return null; }

        int max = intArray[0]; // initialize the max number as the first int
        for(int i = 1; i < intArray.length; i++) { // loop to check if there is a larger number
            if (max < intArray[i]) { max = intArray[i]; } // if so, set max to this number.
        }
        return max; // return maximum number
    }

    public Integer findMin(int[] intArray) {
        if (intArray == null || intArray.length == 0) { return null; }

        int min = intArray[0]; // initialize the min number as the first int
        for(int i = 1; i < intArray.length; i++) { // loop to check if there is a smaller number
            if (min > intArray[i]) { min = intArray[i]; } // if so, set min to this number.
        }
        return min; // return minimum number
    }
}