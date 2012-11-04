package dev.amb.report.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


@JsonIgnoreProperties("dateTimeAccessed")
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
    
}
