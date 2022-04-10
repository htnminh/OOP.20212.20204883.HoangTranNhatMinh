import java.util.Scanner;
import java.lang.Math;

public class EquationsSolver {
    public static String linearSolver(double a, double b) {
        // Solve ax + b = 0
        if (a == 0) {
            if (b == 0) {
                return "Infinitely many arbitrary solutions";
            } else {
                return "No solution";
            }
        } else {
            return "Solution: x = " + (-b/a);
        }
    }

    public static String linearSystemSolver(
            double a11, double a12, double b1, 
            double a21, double a22, double b2) {
        // Solve a11x1 + a12x2 = b1; a21x1 + a22x2 = b2
        // using Cramer's rule
        double D = Determinant.calc(a11, a12, a21, a22);
        double D1 = Determinant.calc(b1, a12, b2, a22);
        double D2 = Determinant.calc(a11, b1, a21, b2);
        Double x1 = D1/D;
        Double x2 = D2/D;

        if (D != 0) {
            return "Solution: x1 = " + x1 + "; x2 = " + x2;
        } else {
            if (D1 == 0 || D2 == 0) {
                return "Infinitely many solutions";
            } else {
                return "No solution";
            }
        }
    }

    public static String quadraticSolver(double a, double b, double c) {
        // solve ax^2 + bx + c = 0
        if (a == 0) {
            return EquationsSolver.linearSolver(b, c);
        } else {
            double delta = b*b - 4*a*c;
            if (delta < 0) {
                return "No solution";
            } else if (delta == 0) {
                return "Double solution: x = " + (-b / (2*a));
            } else {
                double x_1 = (-b + Math.sqrt(delta)) / (2*a);
                double x_2 = (-b - Math.sqrt(delta)) / (2*a);
                return "Two solutions: x = " + x_1 + "; x = " + x_2;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("User exceptions are not handled");
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Linear equation");
        System.out.print("a = ");
        double a = keyboard.nextDouble();
        System.out.print("b = ");
        double b = keyboard.nextDouble();
        System.out.println(EquationsSolver.linearSolver(a, b));
        
        System.out.println("System of two linear equations");
        System.out.print("a11 = ");
        double a11 = keyboard.nextDouble();
        System.out.print("a12 = ");
        double a12 = keyboard.nextDouble();
        System.out.print("b1 = ");
        double b1 = keyboard.nextDouble();
        System.out.print("a21 = ");
        double a21 = keyboard.nextDouble();
        System.out.print("a22 = ");
        double a22 = keyboard.nextDouble();
        System.out.print("b2 = ");
        double b2 = keyboard.nextDouble();
        System.out.println(
            EquationsSolver.linearSystemSolver(a11, a12, b1, a21, a22, b2));
        
        System.out.println("Quadratic equation");
        System.out.print("a = ");
        a = keyboard.nextDouble();
        System.out.print("b = ");
        b = keyboard.nextDouble();
        System.out.print("c = ");
        double c = keyboard.nextDouble();
        System.out.println(EquationsSolver.quadraticSolver(a, b, c));

        keyboard.close();
    }
}

class Determinant {
    public static double calc (double a, double b, double c, double d) {
        /* a b
           c d */
        return a*d - b*c;
    } 
}