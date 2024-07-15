//WAP to pass arrays as an argument
public class passingasargument {
    public static void update(int marks[]) {
        for(int i=0; i<marks.length; i++) //this loop means that one by one, we are going into all the index of the array
        {
            marks[i] = marks[i] + 1; //in this we have updated the marks like if the marks is assigned 97 then in the output it will show 98
        }
    }
    public static void main(String[] args) {
        int marks[] = {97,98,99};
        update(marks);
        //print our marks
        for(int i=0;i<marks.length; i++) {
            System.out.println(marks[i]+" ");
        }
        System.out.println();
    }
}
