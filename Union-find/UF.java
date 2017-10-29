import java.util.*;
import java.io.*;

public class UF{
	private int [] parent;
	private byte [] rank;
	private int count;
	public UF(int n){
		if(n < 0)throw new IllegalArgumentException();
		count = n;
		parent = new int[n];
		rank = new byte[n];
		for(int i = 0; i < n; i++){
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public int find(int p){
		validate(p);
		while(p != parent[p]){
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public void validate(int p){
		int length = parent.length;
		if(p < 0 || p > parent.length)
			throw new IllegalArgumentException();
	}

	public boolean connected(int p, int q){
		return find(p) == find(q);
	}

	public int size(){
		return count;
	}

	public void union(int p, int q){
		int parentP = find(p);
		int parentQ = find(q);
		if(parentP == parentQ) return;
		if(rank[parentP] < rank[parentQ]) parent[parentP] = parentQ;
		else if (rank[parentP] > rank[parentQ]) parent[parentQ] = parentP;
		else{
			parent[parentQ] = parentP;
			rank[parentP]++;
		}
		count--;
	}

	public static void main(String args[]) throws IOException{
		Scanner s = new Scanner(new FileInputStream(new File("tiniUF.txt")));
		s.nextLine();
		int n =s.nextInt();
		UF uf = new UF(n);
		while(s.hasNextLine()){
			int p = s.nextInt();
            int q = s.nextInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
		}
		System.out.println(uf.count + " components");
	}
}