package co.jjsolarte.climaapp.model;

// City.java
public class City {
    private String title;
    private String locationType;
    private long woeid;
    private String lattLong;

//    @JsonProperty("title")
    public String getTitle() { return title; }
//    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

//    @JsonProperty("location_type")
    public String getLocationType() { return locationType; }
//    @JsonProperty("location_type")
    public void setLocationType(String value) { this.locationType = value; }

//    @JsonProperty("woeid")
    public long getWoeid() { return woeid; }
//    @JsonProperty("woeid")
    public void setWoeid(long value) { this.woeid = value; }

//    @JsonProperty("latt_long")
    public String getLattLong() { return lattLong; }
//    @JsonProperty("latt_long")
    public void setLattLong(String value) { this.lattLong = value; }
}
