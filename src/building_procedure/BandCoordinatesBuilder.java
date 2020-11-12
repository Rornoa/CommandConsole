package building_procedure;

import exceptions.*;

import object_of_collection.Coordinates;
import console.ConsoleReader;

import java.text.ParseException;

public class BandCoordinatesBuilder implements ICoordinateBuilder, IMassages {
    private ConsoleReader consoleReader;
    private Coordinates coordinates;

    public BandCoordinatesBuilder(ConsoleReader consoleReader){
        coordinates=new Coordinates();
        this.consoleReader = consoleReader;
    }

    @Override
    public void setX() {
        while (true) {
            System.out.println("Введите координату Х ");
            consoleReader.printDefaultConsoleSymbol();
            try {
                String readLine = consoleReader.getScanner().nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if(readLine.length()==5){
                    System.out.println(messageOfInputValueError);
                    continue;
                }

                long parsedLine = Long.parseLong(readLine);
                coordinates.setX(parsedLine);
                break;

            } catch (NumberFormatException e) {
                System.out.println(messageOfInputValueError);
            }
        }
    }

    @Override
    public void setY() {
        while (true) {
            System.out.println("Введите координату Y ");
            consoleReader.printDefaultConsoleSymbol();
            try {
                String readLine = consoleReader.getScanner().nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if(readLine.length()==5){
                    System.out.println(messageOfInputValueError);
                    continue;
                }

                double parsedLine = Double.parseDouble(readLine);
                coordinates.setY(parsedLine);
                    break;
            } catch (NumberFormatException e) {
                System.out.println(messageOfInputValueError);
            }
        }
    }

    @Override
    public Coordinates create() {
        System.out.println("Введите координаты");
        setX();
        setY();
        return coordinates;
    }
}
