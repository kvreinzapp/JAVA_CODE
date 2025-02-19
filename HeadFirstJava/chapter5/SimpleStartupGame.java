class SimpleStartupGame {
  public static void main(String[] args) {
    int numOfGuess = 0;
    GameHelper helper = new GameHelper();

    SimpleStartup theStartup = new SimpleStartup();
    int randomNum = (int) (Math.random() * 5);

    int[] locations = {randomNum, randomNum + 1, randomNum + 2};
    theStartup.setLocationCells(locations);
    boolean isAlive = true;

    while (isAlive) {
      int guess = helper.getUserInput("enter a number");
      String result = theStartup.checkYourself(guess);
      numOfGuess++;
      // theStartup.showLocationCells(locations);
      if (result.equals("kill")) {
        isAlive = false;
        System.out.println("You took " + numOfGuess + " guesses");
      }
    }
  }
}
