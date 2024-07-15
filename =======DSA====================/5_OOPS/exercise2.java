//What is the output of the following prog?
public class exercise2 extends Car {
    @Override 
    public final String drive() {
        return "driving electric car";
    }

    public static void main(String[] args) {
        final Car car = new exercise2();
        System.out.println(car.drive());
    }
}


class Automobile {
    private String drive() {
        return "driving vehicle";
    }
}

class Car extends Automobile {
    protected String drive() {
        return "driving car";
    }
}