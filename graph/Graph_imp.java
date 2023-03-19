package graph;
import java.util.*;
public class Graph_imp{
    HashMap<Integer,HashMap<Integer,Integer>> map;
    public Graph_imp(int v){
        this.map=new HashMap<>();
        for(int i=1;i<=v;i++){
            map.put(i,new HashMap<>());
        }
    }
    public void Add_Edge(int v1,int v2,int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }
    public boolean contains_edge(int v1,int v2){
        return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
    }
   
    public boolean contains_vertex(int v1){
        return map.containsKey(v1);
    }
    public void remove_edge(int v1,int v2){
        if(contains_edge(v1, v2)){
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }
    }
    public void remove_vertex(int v1){
        for(int key:map.get(v1).keySet()){
            map.get(key).remove(v1);
        }
        map.remove(v1);
    }
    public void disp(){
        for(int key:map.keySet()){
            System.out.println(key+"--->"+map.get(key));
        }
    }
    public boolean hasPath(int src, int dest, HashSet<Integer> visited){
        if( src==dest){
            return true;
        }
        visited.add(src);
        for(int key:map.get(src).keySet()){
            if(!visited.contains(key)){
                boolean ans=hasPath(key, dest, visited);
                if(ans){
                    return ans;
                }
            }
        }
        visited.remove(src);
        return false;
    }
    public void printallPaths(int src, int dest, HashSet<Integer> visited,String ans){
        if( src==dest){
            System.out.println(ans+src);
        }
        visited.add(src);
        for(int key:map.get(src).keySet()){
            if(!visited.contains(key)){
                printallPaths(key, dest, visited, ans+src+" ");
            }
        }
        visited.remove(src);
    }
    public int noofEdge() {
		int sum = 0;
		for (int key : map.keySet()) {
			sum = sum + map.get(key).size();
		}
		return sum / 2;
	}
    public boolean BFS(int src,int dest){
        LinkedList<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        q.add(src);
        while(!q.isEmpty()){
            int r=q.remove();
            
            if(visited.contains(r)){
                continue;
            }
            if(r==dest){
                return true;
            }
            for(int key:map.get(src).keySet()){
                if(!visited.contains(key)){
                    q.add(key);
                }
            }
        }
        return false;
    }
    public boolean DFS(int src,int dest){
        Stack<Integer> q=new Stack<>();
        HashSet<Integer> visited=new HashSet<>();
        q.push(src);
        while(!q.isEmpty()){
            int r=q.pop();
            
            if(visited.contains(r)){
                continue;
            }
            if(r==dest){
                return true;
            }
            for(int key:map.get(src).keySet()){
                if(!visited.contains(key)){
                    q.push(key);
                }
            }
        }
        return false;
    }
    public void BFT(){
        Stack<Integer> q=new Stack<>();
        HashSet<Integer> visited=new HashSet<>();
        for(int src :map.keySet()){
            if(visited.contains(src)){
                continue;
            }
            q.push(src);
            while(!q.isEmpty()){
                int r=q.pop();
                
                if(visited.contains(r)){
                    continue;
                }
                System.out.println(r+" ");
                for(int key:map.get(src).keySet()){
                    if(!visited.contains(key)){
                        q.push(key);
                    }
                }
            }
            
        }
       
    }
    public void DFT(){
        LinkedList<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        for(int src :map.keySet()){
            if(visited.contains(src)){
                continue;
            }
            q.add(src);
            while(!q.isEmpty()){
                int r=q.remove();
                
                if(visited.contains(r)){
                    continue;
                }
                System.out.println(r+" ");
                for(int key:map.get(src).keySet()){
                    if(!visited.contains(key)){
                        q.add(key);
                    }
                }
            }
            
        }
       
    }
    public static void main(String[] args) {
        Graph_imp g = new Graph_imp(7);

		g.Add_Edge(1, 4, 6);
		g.Add_Edge(1, 2, 10);
		g.Add_Edge(2, 3, 7);
		g.Add_Edge(3, 4, 5);
		g.Add_Edge(4, 5, 1);
		g.Add_Edge(5, 6, 4);
		g.Add_Edge(7, 5, 2);
		g.Add_Edge(6, 7, 3);
		//g.display();
		System.out.println(g.noofEdge());
		//g.removeEdge(4, 5);
		//g.removevertex(4);
		g.disp();
		System.out.println(g.hasPath(1, 6, new HashSet<>()));
		g.printallPaths(1,  6, new HashSet<>(), "");
    }
}
