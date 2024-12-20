class SimpleStartup { // Encapsulation?
  private int[] locationCells; // instance variable will defaultly set to null
  private int numOfHits = 0; // default value 0

  public void setLocationCells(int[] locs) {
    locationCells = locs;
  }

  //  public void setSingleCell(int pos, int num) {
  //   locationCells[pos] = num;
  // }

  public void showLocationCells(int[] locs) {
    for (int cell : locationCells) {
      System.out.println(cell);
    }
  }

  public String checkYourself(int guess) {
    String result = "miss";
    for (int i = 0; i < locationCells.length; i++) {
      if (guess == locationCells[i]) {
        result = "hit";
        numOfHits++;
        locationCells[i] = -1;
        break;
      } // end if
    } // end for
    if (numOfHits == locationCells.length) {
      result = "kill";
    } // end if
    System.out.println(result);
    showLocationCells(locationCells);
    return result;
  } // end method
} // close class

public class SimpleStartupTestDrive {
  public static void main(String[] args) {
    SimpleStartup dot = new SimpleStartup(); // Instantiate a SimpleStartup object

    int[] locations = {3, 4, 5};
    dot.setLocationCells(locations); // assign it a location
    //
    int guess = 2; // create and invoke user guess

    if ("miss" == dot.checkYourself(guess)) { // print the test result
      System.out.print("passed");
    }
  }
}
