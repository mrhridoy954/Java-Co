import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Small Cabinet object with user input
        System.out.println("Enter the details for Cabinet:");
        char C = scanner.next().charAt(0);
        scanner.nextLine(); // Consume the newline character
        System.out.print("No. of Door(s): ");
        int doors1 = scanner.nextInt();
        System.out.print("No. of Drawer(s): ");
        int drawers1 = scanner.nextInt();
        System.out.print("Cost (Tk): ");
        double cost1 = scanner.nextDouble();
        SmallCabinet smallCabinet = new SmallCabinet(doors1, drawers1, cost1);

        // Create a Large Cabinet object with user input
        System.out.println("\nEnter the details for Large Cabinet:");
        System.out.print("No. of Door(s): ");
        int doors2 = scanner.nextInt();
        System.out.print("Cost (Tk): ");
        double cost2 = scanner.nextDouble();
        LargeCabinet largeCabinet = new LargeCabinet(doors2, cost2);

        // Create a Kitchen Cabinet object with default values
        KitchenCabinet kitchenCabinet = new KitchenCabinet(1, 9000.0);

        // Display information for each type of furniture
        if (C == 'S') {
            System.out.println("\nInformation for Small Cabinet:");
            smallCabinet.information();
        } else if (C == 'L') {
            System.out.println("\nInformation for Large Cabinet:");
            largeCabinet.information();
        }

        System.out.println("\nInformation for Kitchen Cabinet:");
        kitchenCabinet.information();

        scanner.close();
    }
}
