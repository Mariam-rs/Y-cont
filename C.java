import java.util.*;
import java.io.*;

public class C {
  public static void main(String[] args) throws IOException{
    
    //TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();  
	
	ArrayList<Integer> al1 = new ArrayList<Integer>();
	ArrayList<Integer> al2 = new ArrayList<Integer>();
	ArrayList<Integer> al3 = new ArrayList<Integer>();
	
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	String[] line1 = br.readLine().split(" ");
	int N = Integer.parseInt(line1[0]);
	line1 = br.readLine().split(" ");
	for(int i=0; i<N; i++){
		al1.add(Integer.parseInt(line1[i]));
	}
	line1 = br.readLine().split(" ");
	for(int i=0; i<N; i++){
		al2.add(Integer.parseInt(line1[i]));
	}
	line1 = br.readLine().split(" ");
	for(int i=0; i<N; i++){
		al3.add(Integer.parseInt(line1[i]));
	}
	
	HashSet<Integer> ts1 = new HashSet<Integer>(al1);
	HashSet<Integer> ts2 = new HashSet<Integer>(al2);
	HashSet<Integer> ts3 = new HashSet<Integer>(al3);
	
	HashSet<Integer> diff = new HashSet<Integer>(al1);
	//HashSet<Integer> stack = new HashSet<Integer>();
	
	int cnt =0;
	System.out.println(ts1.equals(ts2));
	System.out.println(ts1.equals(ts3));
	System.out.println(!(ts1.equals(ts2) && (ts1.equals(ts3))));
	
	while(!(ts1.equals(ts2) && (ts1.equals(ts3)))){
		diff.removeAll(ts2);
		System.out.println(diff);
		
		if(!diff.isEmpty()){
			for(Integer  i: diff){
				int index = al1.indexOf(i);
				al1.remove(index);
				al2.remove(index);
				al3.remove(index);
				cnt++;
			}
		}
		diff = new HashSet<Integer>(al1);
		diff.removeAll(ts3);
		if(!diff.isEmpty()){
			for(Integer  i: diff){
				int index = al1.indexOf(i);
				al1.remove(index);
				al2.remove(index);
				al3.remove(index);
				cnt++;
			}
			
		}
		diff = new HashSet<Integer>(al1);
		
	}
	
	//diff.removeAll(ts2);
	///stack.addAll(diff);
	//diff = new HashSet<Integer>(al1);
	//diff.removeAll(ts3);

	System.out.println(cnt);
	
	
	      
    //PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
    //out.println(ts.first());
    //br.close();
    //out.close();
  }  

}