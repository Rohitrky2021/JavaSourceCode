public class cons{
    // student s1=new student();
    public static void main(String args[]){
    student s1=new student();
    s1.name="tohiy";
    s1.rollno=25;
    // s1.password="rky"//this show error
    s1.marks[0]=24;
    s1.marks[1]=77;
    s1.marks[2]=88;
 
    student s2=new student(s1);//copying s1 onj in s2
    s2.password="xyz";
    student s3=new student();
    s1.marks[0]=5;//this cahnge will occur for this
    //shawllow and deep method are there copy;
    
    // System.out.println(s1);
    for (int i = 0; i < 3; i++) {
        System.out.println(s2.marks[i]);
    }



    } 
}

class student{
    String name;
    int rollno;
    String password;
    int marks[];

    //shallow const....
    // student(student s1){//this is ur copy constructor
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.rollno=s1.rollno;
    //     this.marks=s1.marks;//yha array ka reeference copy hoke AAya h
    // }

    //deep const.....
    student(student s1){//this is ur copy constructor
        marks=new int[3];
        this.name=s1.name;
        this.rollno=s1.rollno;
        for(int i=0;i<marks.length;i++){
            this.marks[i]=s1.marks[i];

        }
        // this.marks=s1.marks;//yha array ka reeference copy hoke AAya h
    }


    student(){
        marks=new int[3];

        System.out.println("nothing");
            }
    student(String nname){
        marks=new int[3];

        this.name=nname;

    }
    student(int rollno){
        marks=new int[3];

        this.rollno=rollno;
    }        
}
