package application;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CollectionManager collection;

        if (args.length!=0)
            collection=new CollectionManager(new File(args[0]));
        else  collection=new CollectionManager();

        Application app = new Application(collection);
        app.go();

    }
}
