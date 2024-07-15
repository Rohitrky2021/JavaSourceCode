import java.util.*;
public class heap {
    static class Heap{
        ArrayList<Integer> arr  = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x =  arr.size()-1;
            int par = (x-1)/2;   
            while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int idx){
            int left = 2*idx+1;
            int right = 2*idx+2;
            int mididx = idx;
            if(left >= arr.size() && right >= arr.size()){
                return;
            }
            if(left < arr.size() && arr.get(mididx) > arr.get(left)){
                mididx = left;
            }
            if(right < arr.size() && arr.get(mididx) > arr.get(right)){
                mididx = right;
            }
            while(mididx != idx){
                int temp = arr.get(idx);
                arr.set(idx, arr.get(mididx));
                arr.set(mididx, temp);
                heapify(mididx);
               return;
            }  
        }
        public int remove(){
            int temp = arr.get(arr.size()-1);
            arr.set(arr.size()-1,arr.get(0));
            arr.set(0,temp);
            int x=  arr.remove(arr.size()-1);
             heapify(0);
             return x;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }
    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.add(2);
        hp.add(3);
        hp.add(4);
        hp.add(5);
        hp.add(10);
        for(int i =0 ; i < hp.arr.size() ; i++ ){
            System.out.print(hp.arr.get(i)+" ");
        }
        hp.add(1);
        for(int i =0 ; i < hp.arr.size() ; i++ ){
            System.out.print(hp.arr.get(i)+" ");
        }
        System.out.println();
        System.out.println(hp.peek());
        System.out.println(hp.remove());
        System.out.println();
        while(!hp.isEmpty()){
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}
