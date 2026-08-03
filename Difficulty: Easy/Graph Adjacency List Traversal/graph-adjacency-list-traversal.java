
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        // code here
         List<List<Integer>> adj = new ArrayList<>();
         for(int i =0; i<V; i++){
             adj.add(new ArrayList<>());
         }
         for(int[] e: edges){
             int u = e[0];
             int v = e[1];
             
             adj.get(u).add(v);
              adj.get(v).add(u);
         }
         return adj;
    }
}