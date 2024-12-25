public class SimpleLocation {
  public double latitude;
  public double longitude;

  public SimpleLocation() {
    this.latitude = 32.9;
    this.longitude = -117.2;
  }

  public SimpleLocation(double lat, double lon) {
    this.latitude = lat;
    this.longitude = lon;
  }

  public double distance(SimpleLocation other) {
    return getDist(this.latitude, this.longitude, other.latitude, other.longitude);
  }

  public double distance(double otherLat, double otherLon) {
    return getDist(this.latitude, this.longitude, otherLat, otherLon);
  }

}
