import java.util.*;

public class Graph {
    private Map<String, LinkedHashSet<String>> map = new HashMap();
    static LinkedList<String> temp = new LinkedList<String>();
    //creates nodes and add edges between two strings
    public void addEdge(String node1, String node2) {
        LinkedHashSet<String> adjacent = map.get(node1);
        if(adjacent==null) {
            adjacent = new LinkedHashSet<String>();
            map.put(node1, adjacent);
        }
        adjacent.add(node2);
    }
    //returns all adjacent nodes to an input node
    public LinkedList<String> adjacentNodes(String last) {
        LinkedHashSet<String> adjacent = map.get(last);
        if(adjacent==null) {
            return new LinkedList<String>();
        }
        return new LinkedList<String>(adjacent);
    }
    //function to find the explosion of  a given node
    static void explosion(Graph graph, LinkedList<String> visited) {
        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
        // examine adjacent nodes
        temp.add(main.transaction);
 
        // in breadth-first, recursion needs to come after visiting adjacent nodes
    	for (String node : nodes) {
        	if (visited.contains(nodes)) {
        		break;
        	}
        	//if already in temp to be printed add *
        	if(temp.contains(node))
    			node = node + "*";
        	
        	visited.add(node);
        	printExplosion(visited, temp);
        	temp.addAll(visited);
        	explosion(graph, visited);
        	visited.removeLast();
     	}
    }
    //function to print explosion 
    static void printExplosion(LinkedList<String> visited, LinkedList<String> temp){
    	LinkedList<String> printed = new LinkedList<String>();
    	for(int i=0; i < visited.size(); i++){
    		//if the transaction print
    		if(visited.get(i).equals(temp.get(0))){
    			System.out.println("  " +visited.get(i));
    		}
    		//if a child of the transaction print with space
    		if(!(temp.contains(visited.get(i)))){
				System.out.print("  "+visited.get(i));
				printed.add(visited.get(i));
			}
    		//else add space and repeat
			else{
				String hold = visited.get(i);
				visited.remove(i);
				visited.add(i, "  ");
				System.out.print(visited.get(i));
				System.out.print(" ");
				int asterik = hold.indexOf("*");
				if(asterik > 0)
					System.out.print(hold);
			}
		}
		System.out.println("");
    }
}