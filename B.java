import java.util.*;
import java.io.*;

public class B {
  public static void main(String[] args) throws IOException{
	  
	  BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	  String[] line1 = br.readLine().split(" ");
	  int n = Integer.parseInt(line1[0]);
	  int b = Integer.parseInt(line1[1]);
      int[] a = new int[n];

        int indexB = -1;
		line1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line1[i]);
            if (a[i] == b) {
                indexB = i;
            }
        }

        //scanner.close();

        Map<Integer, Integer> leftBalance = new HashMap<>();
        int balance = 0;
        leftBalance.put(balance, 1);

        for (int i = indexB - 1; i >= 0; i--) {
            if (a[i] > b) {
                balance++;
            } else if (a[i] < b) {
                balance--;
            }

            leftBalance.put(balance, leftBalance.getOrDefault(balance, 0) + 1);
        }

        balance = 0;
        int result = 0;

        for (int i = indexB; i < n; i++) {
            if (a[i] > b) {
                balance++;
            } else if (a[i] < b) {
                balance--;
            }

            result += leftBalance.getOrDefault(-balance, 0);
        }

        System.out.println(result);
    
    //TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();        
    /*BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	String[] line1 = br.readLine().split(" ");
	int N = Integer.parseInt(line1[0]);
	int B = Integer.parseInt(line1[1]);
	int[] arr = new int[N];
	line1 = br.readLine().split(" ");
	for(int i=0; i<N; i++){
		arr[i] = Integer.parseInt(line1[i]);
		System.out.println(arr[i]);
	}
		
    int count;
	if ((B==N) || (B==1)) {
		count = 1;
	} else{
		
		
		
	}
	
	 
    //PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
    //out.println(ts.first());
    //br.close();
    //out.close(); */
  }
  

}