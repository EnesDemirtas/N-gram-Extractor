/**
 * @author Enes Demirtas
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NgramExtractor {
	
	public static void main(String[] args) throws IOException {
		
		String test = "";
		Scanner scan = new Scanner(new File(args[0]));
		scan.useDelimiter("[^a-zA-Z-']+");
		while(scan.hasNext()) {
			test += scan.next().toLowerCase() + " ";
			
		}
		
		
		String[] words = test.split(" ");

		
		
		Map<String, Integer> freq = new HashMap<>();
		int n = Integer.parseInt(args[2]);
		
		// To determine tokens and put them in HashMap
		for (int i = 0; i < words.length - n + 1; i++) {
			String token = "";
			int counter = 0;
			int index = i;
			while (counter < n) {
				token += words[index].toLowerCase();
				counter++;
				index++;
				if(counter >= n) {
					break;
				} else {
					token += " ";
				}
			}
			token = token.replace('ý', 'i');
			if(freq.get(token) == null) {
				freq.put(token, 1);
			} else {
				freq.put(token, freq.get(token)+1);
			}
		}
		
		
		// Sorting procedure
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(freq.entrySet());
		
	    Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
	    	public int compare(Map.Entry<String, Integer> o1,  
	    			Map.Entry<String, Integer> o2) { 
	                return (o2.getValue()).compareTo(o1.getValue()); 
	            } 
	        });
	      	
	    HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
	    for (Map.Entry<String, Integer> aa : list) { 
	    	temp.put(aa.getKey(), aa.getValue()); 
	    } 
	        

		
		
		
		//To write outputs to output.csv
		File file = new File(args[1]);
		file.createNewFile();
		
		FileWriter writer = new FileWriter(file);
		
		writer.write("Total number of tokens: " + freq.size() + "\n\n");
		System.out.print("Total number of tokens: " + freq.size() + "\n\n");
		writer.write("ngram,count,frequency\n");
		System.out.print("ngram,count,frequency\n");
		
        for (Map.Entry<String, Integer> en : temp.entrySet()) {
        	double frequency = ((double)en.getValue()/(double)freq.size())*100.0;
            writer.write(en.getKey()+","+en.getValue()+","+frequency+"\n");
            System.out.print(en.getKey()+","+en.getValue()+","+frequency+"\n");

        } 
		

		scan.close();
		writer.close();
		

	}

}
