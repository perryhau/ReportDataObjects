package dev.amb.report.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;


public class Entity {
    
    @JsonProperty("value")
    private String value;
    
    @JsonProperty("type")
    private String type;
    
    @JsonProperty("startIndex")
    private long startIndex;
    
    @JsonProperty("endIndex")
    private long endIndex;
    
    // include an alias list just in case; natural to store longest form of entity value, and then store cooccurences in this list
    private ArrayList<Entity> aliases = new ArrayList<Entity>();
    
    Entity() {  }
    
    Entity(String valueIn, String typeIn, long startIn, long endIn) {
        this.setValue(valueIn);
        this.setType(typeIn);
        this.setStartIndex(startIn);
        this.setEndIndex(endIn);
    }
    
    Entity(String valueIn, String typeIn, long startIn, long endIn, ArrayList<Entity> aliasesIn) {
        this.setValue(valueIn);
        this.setType(typeIn);
        this.setStartIndex(startIn);
        this.setEndIndex(endIn);
        this.setAliases(aliasesIn);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(long startIndex) {
        this.startIndex = startIndex;
    }

    public long getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(long endIndex) {
        this.endIndex = endIndex;
    }

    public ArrayList<Entity> getAliases() {
        return aliases;
    }

    public void setAliases(ArrayList<Entity> aliases) {
        this.aliases = aliases;
    }
}
