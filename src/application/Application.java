package application;

import building_procedure.BandBuilder;
import console.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Application {

    private boolean needExit = false;
    private CollectionManager collectionManager;
    private CommandArgumentHandler commandArgumentHandler;

    Application(){
        this.commandArgumentHandler = new CommandArgumentHandler();
        this.collectionManager = new CollectionManager(this);
    }

    void go(Scanner scanner) {
        System.out.println("Добро пожаловать в музыкальный блокнот!\n" + "Для того чтобы ознакомиться с возможными командами введите help\n");
        String defaultConsoleSymbol = ">>";
        System.out.print(defaultConsoleSymbol);
        BandBuilder bandBuilder = new BandBuilder(scanner);
        while (!needExit) {
                String command = scanner.nextLine().trim();
                switch (command) {
                    case "show":
                        collectionManager.show();
                    break;

                    case "info":
                        collectionManager.info();
                    break;

                    case "help":
                        collectionManager.help();
                    break;

                    case "clear":
                        collectionManager.clear();
                    break;

                    case "save":
                        collectionManager.save();
                    break;

                    case "remove_first":
                        collectionManager.removeFirst();
                    break;

                    case "exit":
                        collectionManager.exit();
                    break;

                    case "print_field_ascending_label":
                        collectionManager.printFieldAscendingLabel();
                    break;

                    case "add" :
                        collectionManager.add(bandBuilder.create());
                    break;

                    case "remove_by_id":
                        collectionManager.removeById(commandArgumentHandler.treatmentInt());
                    break;

                    case "remove_lower":
                        collectionManager.removeLower(bandBuilder.create());
                    break;

                    case "update":
                        collectionManager.update((long)commandArgumentHandler.treatmentInt(),bandBuilder.create());
                    break;

                    case "insert_at_index":
                        collectionManager.insertAtIndex(commandArgumentHandler.treatmentInt(),bandBuilder.create());
                    break;

                    case "filter_starts_with_name":
                        collectionManager.filterStartsWithName(commandArgumentHandler.treatmentString());
                    break;

                    case "count_less_than_genre":
                        collectionManager.coutLessThanGanre(commandArgumentHandler.treatmentString());
                    break;

                    case "execute_script":
                        collectionManager.executeScript();
                    break;
                    case "stop":
                        return;

                    default:
                        System.out.println(" Такой команды нет ");
                }
        }
    }
}



