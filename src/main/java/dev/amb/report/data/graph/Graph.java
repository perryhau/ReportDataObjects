package dev.amb.report.data.graph;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 *
 * @author AntB
 */
public class Graph {

    @JsonProperty("graphId")
    private String graphId;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("timestamp")
    private Long timestamp;
    
    @JsonProperty("nodes")
    private ArrayList<Node> nodes;
    
    @JsonProperty("links")
    private ArrayList<Link> links;

    
    public Graph() {    }
    
    public Graph(String gId, String descIn, long timeIn, ArrayList<Node> nodesIn, ArrayList<Link> linksIn) {
        this.setGraphId(gId);
        this.setDescription(descIn);
        this.setNodes(nodesIn);
        this.setLinks(linksIn);
        this.setTimestamp(timeIn);
    }
    
    public String getGraphId() {
        return graphId;
    }

    public void setGraphId(String graphId) {
        this.graphId = graphId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Link> links) {
        this.links = links;
    }
}
