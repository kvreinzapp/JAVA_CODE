public class p18_PhraseOMatic {
  public static void main(String[] args) {
    // 3 set of phrase ready to be combined
    String[] wordListOne = {
      "agnostic",
      "opinionated",
      "voice activated",
      "haptically driven",
      "extensible",
      "reactive",
      "agent based",
      "functional",
      "AI enabled",
      "strongly typed"
    };

    String[] wordListTwo = {
      "loosely coupled",
      "six sigma",
      "asynchronous",
      "event driven",
      "pub-sub",
      "IoT",
      "cloud mesh",
      "architecture",
      "perspective",
      "design",
      "orientation"
    };

    String[] wordListThree = {
      "frame work",
      "library",
      "DSL",
      "REST API",
      "repository",
      "perspective",
      "design",
      "orientation"
    };

    // generate the rand which will not out of the range
    int oneLength = wordListOne.length;
    int twoLength = wordListTwo.length;
    int threeLength = wordListThree.length;

    java.util.Random randomGenerator = new java.util.Random();
    int rand1 = randomGenerator.nextInt(oneLength);
    int rand2 = randomGenerator.nextInt(twoLength);
    int rand3 = randomGenerator.nextInt(threeLength);

    // final display step
    String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
    System.out.println("What we need is a " + phrase);
  }
}
