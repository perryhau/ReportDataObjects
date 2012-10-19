package dev.amb.report.data.graph;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;

/**
 *
 * @author AntB
 */
public class Link {
    
    @JsonProperty("startNode")
    private Node startNode;
    
    @JsonProperty("endNode")
    private Node endNode;

    @JsonProperty("linkUid")
    private String linkUid;
    
    @JsonProperty("linkType")
    private String linkType;
    
    @JsonProperty("directed")
    private int directed;
    
    @JsonProperty("properties")
    HashMap<String, String> properties = new HashMap<String, String>();

    public Link() { }
    
    public Link(Node start, Node end, String type, int dir, String uid) {
        this.setStartNode(start);
        this.setEndNode(end);
        this.setLinkType(type);
        this.setDirected(dir);
        this.setLinkUid(uid);
    }
    
    public Link(Node start, Node end, String type, int dir, String uid, HashMap<String, String> props) {
        this.setStartNode(start);
        this.setEndNode(end);
        this.setLinkType(type);
        this.setDirected(dir);
        this.setLinkUid(uid);
        this.setProperties(props);
    }

    public Node getStartNode() {
        return startNode;
    }

    public void setStartNode(Node startNode) {
        this.startNode = startNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public void setEndNode(Node endNode) {
        this.endNode = endNode;
    }
    
    public String getLinkUid() {
        return linkUid;
    }

    public void setLinkUid(String linkUid) {
        this.linkUid = linkUid;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public int getDirected() {
        return directed;
    }

    public void setDirected(int directed) {
        this.directed = directed;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Link == true) {
            Link l = (Link) o;
            if (l.directed == this.directed) {
                // if properties match
                if (l.getProperties() == null && l.getProperties() == null) {
                    // assume that we want to say null props are not equal
                    return false;
                } else {
                    boolean propertyMatch = true;
                    // do we have the same properties?
                    if (l.getProperties().keySet().size() == this.getProperties().keySet().size()) {
                        for (String lProp : l.getProperties().keySet()) {
                            // does o props contain n?
                            if (this.getProperties().keySet().contains(lProp) == false) {
                                propertyMatch = false;
                                return false;
                            }
                        }
                        // do we have any property values that do not match?
                        if (propertyMatch == true) {
                            // we have matching property names
                            boolean valueMatch = true;
                            for (String prop : l.getProperties().keySet()) {
                                if (l.getProperties().get(prop).equals(
                                        this.getProperties().get(prop)) == false) {
                                    valueMatch = false;
                                    return false;
                                }
                            }
                            // should only return true
                            return valueMatch;
                        }
                    }
                }

            }
        }
        return false;
    }
}
