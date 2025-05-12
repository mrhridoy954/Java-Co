import java.util.Scanner;

class Furniture {
    private int numOfDrawers;
    private String type;
    private boolean isColourful;
    private int numOfDoors;
    private double cost;

    public Furniture(int numOfDrawers, String type, boolean isColourful, int numOfDoors, double cost) {
        this.numOfDrawers = numOfDrawers;
        this.type = type;
        this.isColourful = isColourful;
        this.numOfDoors = numOfDoors;
        this.cost = cost;
    }

    public void information() {
        System.out.println("The furniture type is a " + type);
        if (isColourful) {
            System.out.println("Colourful");
        } else {
            System.out.println("No colour");
        }
        System.out.println(numOfDoors + " door(s)");
        System.out.println(numOfDrawers + " drawer(s)");
        System.out.println("The cost of the furniture is Tk " + cost);
    }
}






