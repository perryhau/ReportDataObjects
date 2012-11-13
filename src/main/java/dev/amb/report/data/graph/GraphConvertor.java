
package dev.amb.report.data.graph;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.amb.report.data.Entity;
import dev.amb.report.data.Place;
import dev.amb.report.data.Report;
import dev.amb.report.data.Term;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author AntB
 */
public class GraphConvertor {
    
    
    public static Graph convertReportToGraph(Report report) throws JsonProcessingException {
        
        // create a graph where report is linked:
        // report =refrerenceFrom=> source
        // report <=occurs: #freq = terms
        // report <=containedIn= places
        // report <=containedIn= entities
        
        Graph graph = new Graph();
        
        graph.setDescription("Graph_" + report.getTitle() + "_" + report.getReportUid());
        graph.setGraphId(report.getReportUid());
        
        Long publish = report.getSource().getPublishedTimestamp();
        Long access = report.getSource().getAccessedTimestamp();
        
        if(publish == null && access == null) {
            graph.setTimestamp(new Date().getTime());
            
        } else if(access == null && publish != null) {
            graph.setTimestamp(publish);
            
        } else if(access != null && publish == null) {
            graph.setTimestamp(access);
            
        } else if(publish != null && access != null){
            graph.setTimestamp(publish);
        }
        
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Link> links = new ArrayList<Link>();
        
        
        Node rep = NodeConvertor.reportToNode(report, false);
        nodes.add(rep);
        
        Node source = NodeConvertor.sourceToNode(report.getSource());
        nodes.add(source);
        
        Link reportToSourceLink = new Link(rep, source, "referencedFrom", 1, report.getReportUid());
        links.add(reportToSourceLink);
        
        // process places
        for (Place place : report.getPlaces()) {
            Node p = NodeConvertor.placeToNode(place);
            nodes.add(p);
            
            Link placeToReport = new Link(rep, p, "contains" , 1 , report.getReportUid());
            links.add(placeToReport);
        }
        
        // process entities
        for (Entity ent : report.getEntities()) {
            Node e = NodeConvertor.entityToNode(ent);
            nodes.add(e);
            
            Link entToReport = new Link(rep, e, "contains", 1, report.getReportUid());
            links.add(entToReport);
        }
        
        // process terms
        for (Term term : report.getTerms()) {
            Node t = NodeConvertor.termToNode(term);
            nodes.add(t);
            
            Link termToReport = new Link(t, rep, "contains" , 1, report.getReportUid());
            termToReport.getProperties().put("frequency", String.valueOf(term.getFrequency()));
            links.add(termToReport);
        }
        
        graph.setNodes(nodes);
        graph.setLinks(links);
        
        return graph;
    }

}
