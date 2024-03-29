/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.amb.report.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author AntB
 */
public class Report {
    
    
    @JsonProperty("reportUid")
    private String reportUid;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("source")
    private Source source;
    
    @JsonProperty("content")
    private String content;
    
    @JsonProperty("places")
    private ArrayList<Place> places = new ArrayList<Place>();
    
    @JsonProperty("entities")
    private ArrayList<Entity> entities = new ArrayList<Entity>();
    
    @JsonProperty("terms")
    private ArrayList<Term> terms = new ArrayList<Term>();
    
    @JsonProperty("sentences")
    private ArrayList<String> sentences;
    
    public Report() {   }
    
    public Report(String uid, String titleIn, Source sourceIn, String contentIn) {
        this.setReportUid(uid);
        this.setTitle(titleIn);
        this.setSource(sourceIn);
        this.setContent(contentIn);
    }
    
    public Report(String uid, String titleIn, Source sourceIn, String contentIn, ArrayList<Entity> entitiesIn, ArrayList<Term> termsIn, ArrayList<Place> placesIn) {
        this.setReportUid(uid);
        this.setTitle(titleIn);
        this.setSource(sourceIn);
        this.setContent(contentIn);
        this.setTerms(termsIn);
        this.setPlaces(placesIn);
        this.setEntities(entitiesIn);
    }

    public String getReportUid() {
        return reportUid;
    }

    final public void setReportUid(String reportUid) {
        this.reportUid = reportUid;
    }
    
    public String getTitle() {
        return title;
    }

    final public void setTitle(String title) {
        this.title = title;
    }

    public Source getSource() {
        return source;
    }

    final public void setSource(Source source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    final public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    final public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    final public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public ArrayList<Term> getTerms() {
        return terms;
    }

    final public void setTerms(ArrayList<Term> terms) {
        this.terms = terms;
    }

    public ArrayList<String> getSentences() {
        return sentences;
    }

    final public void setSentences(ArrayList<String> sentences) {
        this.sentences = sentences;
    }
    
}
