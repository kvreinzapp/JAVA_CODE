package module3;

// Java utilities libraries
import java.util.ArrayList;
import java.util.List;

// Processing library
import processing.core.PApplet;

// Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

// Parsing library
import parsing.ParseFeed;

/** EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 * Date: July 17, 2015
 * */
public class EarthquakeCityMap extends PApplet {

    // You can ignore this.  It's to keep eclipse from generating a warning.
    private static final long serialVersionUID = 1L;

    // IF YOU ARE WORKING OFFLINE, change the value of this variable to true
    private static final boolean offline = false;
    
    // Less than this threshold is a light earthquake
    public static final float THRESHOLD_MODERATE = 5;
    // Less than this threshold is a minor earthquake
    public static final float THRESHOLD_LIGHT = 4;

    /** This is where to find the local tiles, for working without an Internet connection */
    public static String mbTilesString = "blankLight-1-3.mbtiles";
    
    // The map
    private UnfoldingMap map;
    
    // Feed with magnitude 2.5+ Earthquakes
    private String earthquakesURL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

    public void setup() {
        size(950, 600);

        if (offline) {
            map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
            earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
        } else {
            map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
            // IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
            // earthquakesURL = "2.5_week.atom";
        }
        
        map.zoomToLevel(2);
        MapUtils.createDefaultEventDispatcher(this, map);	
            
        // The List you will populate with new SimplePointMarkers
        List<Marker> markers = new ArrayList<Marker>();

        // Use provided parser to collect properties for each earthquake
        // PointFeatures have a getLocation method
        List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
        
        // Add a loop here that calls createMarker to create a new SimplePointMarker for each PointFeature in earthquakes
        // Then add each new SimplePointMarker to the List markers
        for (PointFeature feature : earthquakes) {
        	markers.add(createMarker(feature));
        }
        
        // Add the markers to the map so that they are displayed
        map.addMarkers(markers);
    }
        
    /* createMarker: A suggested helper method that takes in an earthquake 
     * feature and returns a SimplePointMarker for that earthquake
     * 
     * In step 3 You can use this method as-is.  Call it from a loop in the 
     * setup method.  
     * 
     * TODO (Step 4): Add code to this method so that it adds the proper 
     * styling to each marker based on the magnitude of the earthquake.  
     */
    private SimplePointMarker createMarker(PointFeature feature) {
        // Create a new SimplePointMarker at the location given by the PointFeature
        SimplePointMarker marker = new SimplePointMarker(feature.getLocation());
        
        Object magObj = feature.getProperty("magnitude");
        float mag = Float.parseFloat(magObj.toString());
        
        // Colors for different magnitudes
        int yellow = color(255, 255, 0);   // Light earthquakes
        int blue = color(0, 0, 255);       // Moderate earthquakes
        int red = color(255, 0, 0);        // Strong earthquakes

        // Style the marker based on the magnitude
        if (mag < THRESHOLD_LIGHT) {
            marker.setColor(yellow);
            marker.setRadius(8);
        } else if (mag < THRESHOLD_MODERATE) {
            marker.setColor(blue);
            marker.setRadius(12);
        } else {
            marker.setColor(red);
            marker.setRadius(16);
        }
        
        // Return the marker
        return marker;
    }
    
    public void draw() {
        background(220);
        map.draw();
        addKey();
    }


    // Helper method to draw key in GUI
    private void addKey() {	
        // Draw the rectangle for the key
        fill(255);
        rect(25, 50, 150, 250);
        
        // Add text and markers for each type of earthquake
        fill(0);
        textSize(12);
        text("Earthquake Key", 50, 75);
        
        fill(color(255, 0, 0));
        ellipse(50, 125, 16, 16);
        fill(0);
        text("5.0+ Magnitude", 75, 130);
        
        fill(color(0, 0, 255));
        ellipse(50, 175, 12, 12);
        fill(0);
        text("4.0+ Magnitude", 75, 180);
        
        fill(color(255, 255, 0));
        ellipse(50, 225, 8, 8);
        fill(0);
        text("Below 4.0", 75, 230);
    }
}