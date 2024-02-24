import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution332 {
    private void visitAirport(String airport, Map<String, LinkedList<String>> graph, List<String> route) {
     LinkedList<String> destinations = graph.getOrDefault(airport, new LinkedList<>());
     while (!destinations.isEmpty()) {
         String nextAirport = destinations.pollFirst();
         visitAirport(nextAirport, graph, route);
     }
     route.add(0, airport); // Add to the beginning of the route
 }
 
 public List<String> findItinerary(List<List<String>> tickets) {
     Map<String, LinkedList<String>> graph = new HashMap<>();
     for (List<String> ticket : tickets) {
         String from = ticket.get(0);
         String to = ticket.get(1);
         graph.putIfAbsent(from, new LinkedList<>());
         graph.get(from).add(to);
     }
 
     for (LinkedList<String> destinations : graph.values()) {
         Collections.sort(destinations); // Sort destinations lexicographically
     }
 
     List<String> route = new ArrayList<>();
     visitAirport("JFK", graph, route);
     return route;
 }
 }
