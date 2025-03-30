import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter two number to devide:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        try {
            int result = num1 / num2;
            System.out.println("The quotient is: " + result);
            System.out.println("Rest of the program.");
        }
        catch(ArithmeticException anything) {
            System.out.println("You Cannot divide by Zero.");

            System.out.println("Rest of the program.");
        }
        /*
        *input mismatch
        *array index of bound
        *file not found
        *class not found
        *illegal triangle
         */
    }
}
