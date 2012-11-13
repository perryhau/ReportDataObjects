package dev.amb.report.data.graph;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.amb.report.data.Entity;
import dev.amb.report.data.Place;
import dev.amb.report.data.Report;
import dev.amb.report.data.Source;
import dev.amb.report.data.Term;
import java.util.Date;

/**
 *
 * @author AntB
 */
public class NodeConvertor {

    public static Node entityToNode(Entity ent) throws JsonProcessingException {

        Node node = new Node();

        node.setNodeUid(ent.getValue());
        node.setType(ent.getType());

        if (ent.getAliases() != null && ent.getAliases().isEmpty() == false) {
            ObjectMapper mapper = new ObjectMapper();

            for (Entity alias : ent.getAliases()) {

                // store each entity alias using JSON string for the entity object
                String aliasEnt = mapper.writeValueAsString(alias);
                node.getProperties().put("alias" + alias.getValue(), aliasEnt);
            }

        }
        return node;
    }

    public static Node reportToNode(Report report, boolean storeListsAsJson) throws JsonProcessingException {

        Node node = new Node();
        node.setNodeUid(report.getReportUid());
        node.setType("report");
        node.getProperties().put("content", report.getContent());

        // add lists as JSON - can always rebuilt
        if (storeListsAsJson == true) {
            ObjectMapper mapper = new ObjectMapper();
            node.getProperties().put("entities", mapper.writeValueAsString(report.getEntities()));
            node.getProperties().put("places", mapper.writeValueAsString(report.getPlaces()));
            node.getProperties().put("terms", mapper.writeValueAsString(report.getTerms()));
            return node;
        } else {
            return node;
        }
    }

    static Node sourceToNode(Source source) {
        
        Node node = new Node();
        node.setNodeUid(source.getSourceUrl());
        node.setType("source");
        node.getProperties().put("name" , source.getName());
//        node.getProperties().put("timestamp" , String.valueOf(source.getDateTimeAccessed()));
        
        return node;
    }
    
    public static Node placeToNode(Place place) {
        Node node = new Node();
        
        node.setNodeUid(place.getPlaceName());
        node.setType("place");
        node.setTimestamp(new Date().getTime());
        node.getProperties().put("placeName" , place.getPlaceName());
        node.getProperties().put("country" , place.getCountry());
        node.getProperties().put("latitide" , String.valueOf(place.getLatitude()));
        node.getProperties().put("longitude" , String.valueOf(place.getLongitude()) );
        
        return node;
    }

    public static Node termToNode(Term term) {
        Node node = new Node();
        
        node.setType("term");
        node.setNodeUid(term.getTerm());
        node.getProperties().put("term" , term.getTerm());
        node.getProperties().put("frequency" , String.valueOf(term.getFrequency()));
        
        return node;
    }
}
