// import java.util.Stack;
// import java.util.TreeMap;

// public class Robot_collision {
    
// }
// class Solution {
//     public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String dir) {
//         TreeMap<Integer, Integer> tr = new TreeMap<Integer, Integer>();
//         var stack=new Stack<Map.Entry<Integer, Integer>>();

//         for(int i = 0; i < positions.length; i++){
//             tr.put(positions[i], i);
//         }

//         for(Map.Entry<Integer, Integer> e : tr.entrySet()){
//             if( dir.charAt(stack.peek().value())!= dir.charAt(stack.peek(e.getvakue()))){ // Collide maarega 
//                     int maxval=0;
//                     if(stack.peek().value()!=e.getvakue()){
//                         maxval=Math.abs(stack.peek().value()-e.getvakue());
//                         if(stack.peek().value()>e.getvakue()){
//                             newind=stack.peek().getkey();
//                         }else{
//                             newind=e.getkey();
//                         }
//                     }else{
//                         // skipp & continnue;
//                     }
//             }else{ // Same direction m jaa rha hai jaane do 

//                 stack.push(e);
//             }
//         }

//         return  toArray(new ArrayList<>(stack));
        
//     }
// }
 

public class Robot_collision {
    
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String dir) {
        TreeMap<Integer, Integer> tr = new TreeMap<Integer, Integer>();
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();

        for(int i = 0; i < positions.length; i++){
            tr.put(positions[i], i);
        }

        for(Map.Entry<Integer, Integer> e : tr.entrySet()){
            if(stack.isEmpty() || dir.charAt(stack.peek().getValue()) == dir.charAt(e.getValue())){ 
                stack.push(e);
            } else { 
                while(!stack.isEmpty() && dir.charAt(stack.peek().getValue()) != dir.charAt(e.getValue())){ 
                    int maxval = Math.abs(stack.peek().getKey() - e.getKey());
                    if(stack.peek().getKey() > e.getKey()){
                        int newind = stack.peek().getKey();
                    }else{
                        int newind = e.getKey();
                    }
                    stack.pop();
                }
                if(stack.isEmpty() || dir.charAt(stack.peek().getValue()) == dir.charAt(e.getValue())){ 
                    stack.push(e);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : stack){
            result.add(healths[entry.getValue()]);
        }
        collections.reverse(result);
        return result;
    }
}