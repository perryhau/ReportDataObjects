package dev.amb.report.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


public class Source {

    @JsonProperty("sourceName")
    private String sourceName;
    
    @JsonProperty("sourceUrl")
    private String sourceUrl;
    
    @JsonProperty("dateTimeAccessed")
    private Date dateTimeAccessed;
    
    public Source() { 
        this.dateTimeAccessed = new Date();
    }
    
    public Source(String nameIn, String sourceUrlIn, Date dateTimeIn) {
        this.setName(nameIn);
        this.setSourceUrl(sourceUrlIn);
        this.dateTimeAccessed = dateTimeIn;
    }

    public String getName() {
        return sourceName;
    }

    public void setName(String name) {
        this.sourceName = name;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Date getDateTimeAccessed() {
        return dateTimeAccessed;
    }
    
    // TODO do I need to make sure that there is either a setter or an ignore flag on this property?
    
    
}
