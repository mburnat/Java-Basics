/**
 * Created by Madzia on 2017-03-05.
 */


import java.util.*;
import java.io.IOException;


public class Menu
{
    public static void main(String[] args)
    {
        Figure fFigure = null;

        int choice;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose option:");
            System.out.println("1. Square");
            System.out.println("2. Triangle");
            System.out.println("3. Circle");
            System.out.println("0. Close programme");

            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    fFigure = EnterDate.enterSquare();
                    fFigure.print();
                    System.out.println("Area: " + fFigure.calculateArea());
                    System.out.println("Perimeter: " + fFigure.calculatePerimeter());
                    break;
                }
                case 2: {
                    fFigure = EnterDate.enterTriangle();
                    fFigure.print();
                    System.out.println("Area: " + fFigure.calculateArea());
                    System.out.println("Perimeter: " + fFigure.calculatePerimeter());
                    break;
                }
                case 3: {
                    fFigure = EnterDate.enterCircle();
                    fFigure.print();
                    System.out.println("Area: " + fFigure.calculateArea());
                    System.out.println("Perimeter: " + fFigure.calculatePerimeter());
                    break;
                }


            }
        }while (choice != 0);
    }
}

abstract class Figure implements Print
{
    abstract protected double calculateArea();
    abstract protected double calculatePerimeter();
}

interface Print
{
    void print();
}

class Square extends Figure implements Print
{
    public void print()
    {
        System.out.println("a: " + a);
    }

    int a ;

    Square(int a)
    {
        this.a = a;

        try
        {
            if(a <= 0)
                throw new IOException();
        }

        catch(IOException exception)
        {
            System.out.println("Value should be different from zero. "+"Terminating programme.");
            System.exit(1);
        }
    }
    protected double calculateArea()
    {
        return (double)a*a;
    }

    protected double calculatePerimeter()
    {
        return (double)4*a;
    }
}

class Triangle extends Figure implements Print
{
    public void print()
    {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);

    }

    int a = 0;
    int b = 0;
    int c = 0;


    Triangle(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;


        try
        {
            if(a <= 0 || b <= 0 || c <= 0 )
                throw new IOException();
        }

        catch(IOException exception)
        {
            System.out.println("Value should be different from zero. "+"Terminating programme.");
            System.exit(1);
        }
    }
    protected double calculateArea()
    {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    protected double calculatePerimeter()
    {
        return (double)(a+b+c);
    }
}

class Circle extends Figure implements Print
{
    public void print()
    {
        System.out.println("r: " + r);
    }

    int r = 0;

    Circle(int r)
    {
        this.r = r;

        try
        {
            if(r <= 0)
                throw new IOException();
        }

        catch(IOException exception)
        {
            System.out.println("Value should be different from zero. "+"Terminating programme.");
            System.exit(1);
        }
    }
    protected double calculateArea()
    {
        return (double)r*r*Math.PI;
    }

    protected double calculatePerimeter()
    {
        return (double)2*r*Math.PI;
    }
}


class EnterDate
{
    static Square enterSquare()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = scanner.nextInt();

        return new Square(a);
    }

    static Triangle enterTriangle()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = scanner.nextInt();
        System.out.println("Enter b: ");
        int b = scanner.nextInt();
        System.out.println("Enter c: ");
        int c = scanner.nextInt();


        return new Triangle(a,b,c);
    }

    static Circle enterCircle()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter r: ");
        int r = scanner.nextInt();

        return new Circle(r);
    }
}