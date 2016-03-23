import java.util.*;

public class main{
	static String transaction = "";
	static String defective = "";
	public static String[] unique = new String[25];
	public static String[] trans = new String[25];
	public static int count =0;

	//function to print arrays
	public void print(String[] array){
		for(int i=0; i < array.length; i++){
			if(array[i] != null){
				System.out.print(array[i] + " ");
			}
		}
		System.out.println("");
	}
	
	//function to get length excluding null
	public int length(String[] array){
		int x = 0;
		for(int i=0; i < array.length; i++){
			if(array[i] != null){
				x++;
			}
		}
		return x;
	}
	//finds all paths to the defective module
	 public void allPaths(Graph graph, LinkedList<String> visited) {
	        LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
	        // examine adjacent nodes
	        for (String node : nodes) {
	            if (visited.contains(node)) {
	                continue;
	            }
	            if (node.equals(defective)) {
	                visited.add(node);
	                printPath(visited);
	                visited.removeLast();
	                break;
	            }
	        }
	        // in breadth-first, recursion needs to come after visiting adjacent nodes
	        for (String node : nodes) {
	            if (visited.contains(node) || node.equals(defective)) {
	                continue;
	            }
	            visited.addLast(node);
	            allPaths(graph, visited);
	            visited.removeLast();
	        }
	    }
	 	//prints all paths to the defective module
	    static void printPath(LinkedList<String> visited) {
	        for (String node : visited) {
	            System.out.print(node);
	            System.out.print(" ");
	        }
	        System.out.println();
	    }  
	}
