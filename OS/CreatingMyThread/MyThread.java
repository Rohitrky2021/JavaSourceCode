
class Myt extends Thread{//extend use krte he Thread ki saari methods ab We Can Use Easily 

    public void run(){
        System.out.println("Mythread");
    }

}


public class MyThread {

    public static void main(String[] args) {
        System.out.println("MAin Thread");
        // Khud se Thread Bnaya ho ya Pehle ka koi ho SubKA Boss Hota h ==>Thread Schduler<==

        Myt t=new Myt();//this euqalent to Thread class ka OBJ bnaya As uski Alredy property Extended h 

        t.start();//Start use krte he jitna bhi thread ho we type of Register it to the ==>Thread Schduler<==
        // preesent in the JVM and it gets all Threads INfo 

        // Handover Done to Schduler Now All Power IT has to kon sa Thread kub KAam krega jisse CPU ka Time Wate na ho!!
        // Simuntaneously Both Thread will run according if any line give Delay


    }
}
