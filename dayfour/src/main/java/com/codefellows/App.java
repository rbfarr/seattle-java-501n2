package com.codefellows;

public class App 
{
    public static void main( String[] args )
    {
        IWindow window = new WindowDecorator(new Window());
        window.minimize();

        if (window instanceof WindowDecorator) {
            ((WindowDecorator) window).maximize();
        }

        //window.doSomething()
        //window.doSomethingElse()

        ICache<Window> cache = new ObjectCache<>();

        int x = 5;
        Integer y = new Integer(5);
        Integer z = 5;
        int w = new Integer(10);

        if (y == x) {
            System.out.println("equal");
        }

        boxDemo(7);
        unboxDemo(new Integer(8));
    }

    private static void boxDemo(Integer i) {
        System.out.println(i);
    }

    private static void unboxDemo(int i) {
        System.out.println(i);
    }
}
