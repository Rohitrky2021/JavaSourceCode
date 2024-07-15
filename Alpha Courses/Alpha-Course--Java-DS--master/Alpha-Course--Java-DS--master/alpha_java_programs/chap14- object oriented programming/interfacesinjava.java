//WAP to implement interfaces in java
public class interfacesinjava {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();
    }
}

interface chessPlayer {
    void moves(); //this is by default public and abstract
}

class Queen implements chessPlayer {
    public void moves() {
        System.out.println("up, down, left, right and diagornal in all for directions");
    }
}

class Rook implements chessPlayer {
    public void moves() {
        System.out.println("up, down, left, right");
    }
}

class King implements chessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal by only one step");
    }
}