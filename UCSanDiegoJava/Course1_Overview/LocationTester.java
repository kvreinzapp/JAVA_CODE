public class LocationTester {
  public static void main(String[] args) {
    SimpleLocatoin ucsd = new SimpleLocatoin(32.9, -117.2);
    SimpleLocatoin lima = new SimpleLocatoin(-12.0, -77.0);
    System.out.println(ucsd.distance(lima));
  }
}
