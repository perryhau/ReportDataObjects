package dev.amb.report.data;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Place {
    
    @JsonProperty("placeName")
    private String placeName;
    
    @JsonProperty("country")
    private String country;
    
    @JsonProperty("latitude")
    private double latitude;
    
    @JsonProperty("longitude")
    private double longitude;
    
    public Place() {    }
    
    public Place(String name, String countryIn, double lat, double lon) {
        this.setPlaceName(name);
        this.setCountry(countryIn);
        this.setLatitude(lat);
        this.setLongitude(lon);
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getKmlCoord() {
        
        return (this.longitude + "," + this.latitude + ",0");
    }
}
