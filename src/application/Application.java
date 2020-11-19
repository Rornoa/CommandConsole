package application;

import building_procedure.BandBuilder;

import java.util.Scanner;

public class Application {

    private String defaultConsoleSymbol = ">>";
    private boolean needExit = false;
    private CollectionManager collectionManager;
    private CommandArgumentHandler commandArgumentHandler;

    Application(CollectionManager collectionManager) {
        this.commandArgumentHandler = new CommandArgumentHandler();
        this.collectionManager = new CollectionManager();
        if (collectionManager != null)
            this.collectionManager = collectionManager;
    }

    void go() {
        System.out.println("Добро пожаловать в музыкальный блокнот!\n" + "Для того чтобы ознакомиться с возможными командами введите help\n");
        System.out.print(defaultConsoleSymbol);
        Scanner scanner = new Scanner(System.in);
        while (!needExit) {
                String command = scanner.nextLine();
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
                        collectionManager.add();
                    break;

                    case "remove_by_id":
                        collectionManager.removeById((int)commandArgumentHandler.treatmentInt());
                    break;

                    case "remove_lower":
                        collectionManager.removeLower(new BandBuilder().create());
                    break;

                    case "update":
                        collectionManager.update((long)commandArgumentHandler.treatmentInt(),new BandBuilder().create());
                    break;

                    case "insert_at_index":
                        collectionManager.insertAtIndex(commandArgumentHandler.treatmentInt(),new BandBuilder().create());
                    break;

                    case "filter_starts_with_name":
                        collectionManager.filterStartsWithName(commandArgumentHandler.treatmentString());
                    break;

                    case "count_less_than_genre":
                        collectionManager.coutLessThanGanre(commandArgumentHandler.treatmentString());
                    break;
                    // TODO: 14.11.2020 Проработать чтение скрипта из файла.
                    case "execute_script":
                        collectionManager.executeScript(commandArgumentHandler.treatmentString());
                    break;

                    default:
                        System.out.println(" Такой команды нет ");
                }
        }
    }
}



