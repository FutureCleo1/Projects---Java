package src;

import java.util.*;

public class Dijkstra {

    public static Map<String, Integer> shortestDistances(Graph g, String start) {
        Map<String, Integer> dist = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String node : g.getNodes()) dist.put(node, Integer.MAX_VALUE);
        dist.put(start, 0);

        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();

            for (Edge edge : g.getNeighbors(current)) {
                int newDist = dist.get(current) + edge.weight;

                if (newDist < dist.get(edge.destination)) {
                    dist.put(edge.destination, newDist);
                    pq.add(edge.destination);
                }
            }
        }
        return dist;
    }

    public static List<String> shortestPath(Graph g, String start, String end) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String node : g.getNodes()) {
            dist.put(node, Integer.MAX_VALUE);
            prev.put(node, null);
        }

        dist.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();
            if (current.equals(end)) break;

            for (Edge edge : g.getNeighbors(current)) {
                int newDist = dist.get(current) + edge.weight;

                if (newDist < dist.get(edge.destination)) {
                    dist.put(edge.destination, newDist);
                    prev.put(edge.destination, current);
                    pq.add(edge.destination);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String node = end;

        while (node != null) {
            path.add(node);
            node = prev.get(node);
        }

        Collections.reverse(path);
        return path;
    }
}
