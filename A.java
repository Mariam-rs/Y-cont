import java.util.*;
import java.io.*;

public class A {
  public static void main(String[] args) throws IOException{
    
    //TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();        
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	String[] line1 = br.readLine().split(" ");
	int R = Integer.parseInt(line1[0]);
	int C  = Integer.parseInt(line1[1]);
	String[] kr = new String[R];
    //String[] line1 = br.readLine().split("#");
    //int n = Integer.parseInt(line1[0]);
	for(int i=0; i<R; i++){
		kr[i] = br.readLine();
	}
	
	TreeSet<String> ts = new TreeSet<String>();
	
	for(int i=0; i<R; i++){
		//kr[i] = br.readLine();
		
		line1 = kr[i].split("#");
		for(int j=0; j<line1.length; j++){
			if(line1[j].length()>1) ts.add(line1[j]);
		}
	}
	
	
	char[][] kros = new char[R][C];
	for(int i=0; i<R; i++){
		for(int j=0; j<C; j++){
			kros[i][j] = kr[i].charAt(j);
		}
	}
	
	//String word = new StringBuilder();
	for(int i=0; i<C; i++){
		String word = "";
		for(int j=0; j<R; j++) {
			word+=kros[j][i];
		}
		
		line1 = word.toString().split("#");
		for(int j=0; j<line1.length; j++){
			if(line1[j].length()>1) ts.add(line1[j]);
		}
		
	
	}
	      
    PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
    out.println(ts.first());
    br.close();
    out.close();
  }  

}