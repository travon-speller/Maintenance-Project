import java.io.*;
import java.util.*;

public class Driver extends main {
	public static void main(String[] args) {
		main Start = new main();
		
		//reads the file and stores it in array
		String text = "/inp.txt";
		String dir = System.getProperty("user.dir");
		//creates a file 
		File file = new File(dir+text); //creates file
		try{
			Scanner sc = new Scanner(file); 
			String input = "";
		    String[] i = new String[100];
				    
		   //this loop reads the text file and put the info into arrays
		    while (sc.hasNextLine()) {  //while file not empty
		    	input += sc.nextLine();			    	
		    	if(input.contains("* *")){
		    		transaction = sc.nextLine();
				    defective = sc.nextLine();
				}
				else{
				     i = input.split(" ");  //split strings by spaces
				     count++;
				}
			}
				  
			sc.close(); //close file
	    
			//ints to control the index of all our arrays
			int y=0;  //trans index
			int z=0;  //unique index
				    
			//two String arrays to hold the input
			String[] left = new String[count*2];
			String[] right = new String[count*2];
			int count1 = count; //second instance of the count variable
				    
			//while count is greater than zero split the input into two arrays
			for(int x = 0; 0 < count; x += 2)
			{ 
			   	left[x]= i[x]; //left side of relation 
			   	right[x]= i[x+1]; //right side of relations
			   	count--;    	
			}
				    
			//finds all the transactions from the relationships
			for(int a=0; a < count1*2; a++){
				//if in both arrays not transaction
			  	if(Arrays.asList(right).contains(left[a])){
					continue;
				}
				//ELSE if not in both and not already in trans array
				//add it and increase index
			  	else if( !(Arrays.asList(trans).contains(left[a]))){
				    trans[y] = left[a];
			    	y++;
				}
			}					    
				    
			//print all the transactions
			System.out.println("There are " + Start.length(trans) + " transactions ");
			Start.print(trans);
				    
			//prints the transaction we want to focus on
			System.out.println("The transaction we are looking at is " + transaction);
				    
		    //finds the unique modules for the chosen transaction
			for(int a =0; a < left.length; a+=2){    	
				if(Arrays.asList(trans).contains(left[a]))
				{
					if(left[a].equals(transaction)){
						if((!(Arrays.asList(unique).contains(right[a])))){
							unique[z] = right[a];
					    	z++;
					    }
				    }
				   	else{
				   	    left[a] = null;
				   	    right[a] = null;
				   	}
				 }
				 if((!(Arrays.asList(unique).contains(right[a])))){
					 unique[z] = right[a];
					 z++;
			     }
			 }
				   
			//prints out the unique modules and amount of unique modules
			System.out.println("There are " + Start.length(unique) + " unique modules for transaction "+ transaction);
			Start.print(unique);
				    
			//prints defective module
			System.out.println("The defective module is " + defective);
			
			//Creates graph to hold the relations
			Graph graph = new Graph();
			count = 0;
			for(int a =0; a < left.length; a++){
				if(left[a]==null){
					continue;
			    }
			    else{
			        graph.addEdge(left[a], right[a]);
			        count++;
			    }
			}
			
			LinkedList<String> visited = new LinkedList<String>();
			visited.add(transaction);
			//prints all defective paths        
			System.out.println("All paths to defective module " + defective);
			Start.allPaths(graph, visited);
			System.out.println("Explosion:");
			
			graph.explosion(graph, visited);
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}
}
