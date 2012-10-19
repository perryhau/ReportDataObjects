package dev.amb.report.data.graph;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;

/**
 *
 * @author AntB
 */
public class Node {

    @JsonProperty("nodeUid")
    private String nodeUid;
    @JsonProperty("timestamp")
    private Long timestamp;
    // do we want to keep an edit history?
    @JsonProperty("nodeType")
    private String type;
    @JsonProperty("properties")
    private HashMap<String, String> properties = new HashMap<String, String>();

    // getter and setter
    public String getNodeUid() {
        return nodeUid;
    }

    public void setNodeUid(String nodeUid) {
        this.nodeUid = nodeUid;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Node) {
            Node n = (Node) o;
            // lets not concern ourselves with the uid
            // let the equals be used to only create properties with distinct properties
            if (n.getProperties() == null && n.getProperties() == null) {
                return false;
            } else {
                boolean propertyMatch = true;
                // do we have the same properties?
                if (n.getProperties().keySet().size() == this.getProperties().keySet().size()) {
                    for (String nProp : n.getProperties().keySet()) {
                        // does o props contain n?
                        if (this.getProperties().keySet().contains(nProp) == false) {
                            propertyMatch = false;
                            return false;
                        }
                    }
                    if (propertyMatch == true) {
                        // we have matching property names
                        boolean valueMatch = true;
                        for (String prop : n.getProperties().keySet()) {
                            if (n.getProperties().get(prop).equals(
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
        return false;
    }
}
