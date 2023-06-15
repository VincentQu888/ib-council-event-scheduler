import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter out = new PrintWriter(System.out);
        
        int max = 0;
        
        
        out.println("\nEnter the number of groups, number of stations and the number of station swaps: ");
        out.println("\nGroups: ");
        out.flush();
        int groups = Integer.parseInt(br.readLine());
        
        out.println("\n# of stations: ");
        out.flush();
        int stations = Integer.parseInt(br.readLine());
        
        out.println("\n# of swaps: ");
        out.flush();
        int swaps = Integer.parseInt(br.readLine());	
        
        
    	HashMap<String, Integer> capacity = new HashMap<>();
        String[][] ans = new String[groups][swaps];

        out.println("\nFor each station enter the name and then the number of groups which it can hold: ");
        for(int i = 0; i < stations; i++) {
        	out.println("\nStation " + (i+1) + " name: ");
            out.flush();
            String name = br.readLine();
            
            out.println("Station " + (i+1) + " capacity: ");
            out.flush();
            int cap = Integer.parseInt(br.readLine());
            max = Math.max(max, cap);
            
            capacity.put(name, cap);
        }
        
        
        for(int i = 0; i < swaps; i++) {
        	int j = 0+i*max < groups ? 0+i*max : 0;
        	
        	for(Entry<String, Integer> next : capacity.entrySet()) {
        		int counter = 0;
        		while(counter < next.getValue()) {
        			ans[j][i] = next.getKey();
        			counter++;
        			j = j+1 < groups ? j+1 : 0;
        		}
        	}
        }

      
        System.out.println();
        int counter = 1;
        for(String[] next : ans) {
        	System.out.print("Group " + counter + " schedule: ");
        	counter++;
        	
        	for(int i = 0; i < next.length; i++) {
        		System.out.print(next[i] + " -> ");
        	}
        	System.out.println("\n");
        }
        
        System.out.println("(if the scheduler created conflicting schedules, that means there is some contradiction in the input)");
    }

}
