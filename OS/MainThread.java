public class MainThread {
    // Thread is an Inbuilt Class in Java start m ek single pre-Default Thread Work krta h 
    public static void main(String[] args) {
        System.out.println("Main Thread");
        String s=Thread.currentThread().getName();//these r static methods Directly hum unke class i.e Thread Se le skte h ,no need to create 
        // their object first!!
        System.out.println(s);//will print -> "main"
        System.out.println(Thread.currentThread().getPriority());//By Default main ki Priority 5 hoti h 
        //we can create our own threads and change their priority also --> Ya main ka bhi change kr skte h!!
        // Do all this using the Inbuild Classes 


        // Lets Modify Thread name and other things now 
        Thread t1=Thread.currentThread();
        t1.setName("firstThread");
        t1.setPriority(2);
        String s1=Thread.currentThread().getName();
        System.out.println(s1);//will print -> "main"
        System.out.println(Thread.currentThread().getPriority());//Now Priority is 2
    }
    
}
