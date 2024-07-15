import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   // A path which Definetly touch every edge and HAMil cycle is the one jis path ka start or end have a connecting BRidge 

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      HashSet<Integer> v = new HashSet<>();
      h(graph, src, v, src + "", src);
   }
   
   public static void h(ArrayList<Edge>[] graph, int src, HashSet<Integer> v, String psf, int osrc){
       if(v.size() == graph.length - 1){ // Visited hamesha piche chlata h then psf-> Path so far 
           System.out.print(psf);
           
           boolean cl = false;
           for(Edge e: graph[src]){  // YE jo AAkhri BUnda h for ex --> 6  eske Neighbour m we check start/ source h ki nhi 
               if(e.nbr == osrc){
                   cl = true;
                   break;
               }
           }
           
           if(cl == true){
               System.out.println("*");
           } else {
               System.out.println(".");
           }
           
           return;
       }
       
       v.add(src); // Added in the Visited 
       for(Edge e : graph[src]){
           if(v.contains(e.nbr) == false){
               h(graph, e.nbr, v, psf + e.nbr, osrc);
           }
       }
       
       v.remove(src);
   }


}