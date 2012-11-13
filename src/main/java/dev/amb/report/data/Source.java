package dev.amb.report.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;
import java.util.Date;


@JsonIgnoreProperties("publishedTimestamp ")
public class Source {

    @JsonProperty("sourceName")
    private String sourceName;
    
    @JsonProperty("sourceUrl")
    private String sourceUrl;
    
    @JsonProperty("accessTimestamp")
    private Long accessTimestamp;
    
    @JsonProperty("publishedTimestamp")
    private Long publishedTimestamp;
    
    public Source() { 
        this.accessTimestamp = new Date().getTime();
    }
    
    public Source(String nameIn, String sourceUrlIn, Date publishedDateTime ) {
        this.setName(nameIn);
        this.setSourceUrl(sourceUrlIn);
        this.accessTimestamp = new Date().getTime();
        this.publishedTimestamp = publishedDateTime.getTime();
    }
    
        public Source(String nameIn, String sourceUrlIn, Calendar publishedDateTime ) {
        this.setName(nameIn);
        this.setSourceUrl(sourceUrlIn);
        this.accessTimestamp = new Date().getTime();
        this.publishedTimestamp = publishedDateTime.getTime().getTime();
    }
        

    public String getName() {
        return sourceName;
    }

    final public void setName(String name) {
        this.sourceName = name;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    final public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Long getAccessedTimestamp() {
        return accessTimestamp;
    }

    public Long getPublishedTimestamp() {
        return publishedTimestamp;
    }
    
    
    
}
