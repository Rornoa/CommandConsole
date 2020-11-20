package application;

import java.io.File;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        CollectionManager collection;
        Application app = new Application();
//        if (args.length!=0)
//            collection=new CollectionManager(new File(args[0]));
//        else  collection=new CollectionManager(app);
//
        app.go(new Scanner(System.in));
    }
}
