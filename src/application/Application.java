package application;

import building_procedure.BandBuilder;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {

    private boolean needExit = false;
    private CollectionManager collectionManager;

    Application(CollectionManager collectionManager) {
        this.collectionManager = new CollectionManager();
        if (collectionManager != null)
            this.collectionManager = collectionManager;
    }

    void go() {
        Scanner scanner = new Scanner(System.in);
        while (!needExit) {
                String[] command = scanner.nextLine().split(" ");
                switch (command[0]) {
                    case "show": {
                        collectionManager.show();
                    }
                        break;
                    case "info": {
                        collectionManager.info();
                    }
                        break;
                    case "help": {
                        collectionManager.help();
                    }
                        break;
                    case "clear":{
                        collectionManager.clear();
                    }
                        break;
                    case "save": {
                        collectionManager.save();

                    }
                        break;
                    case "remove_first": {
                        collectionManager.removeFirst();
                    }
                        break;
                    case "exit": {
                        collectionManager.exit();
                    }
                        break;
                    case "print_field_ascending_label": {
                        collectionManager.printFieldAscendingLabel();
                    }
                    case "add" :{
                        collectionManager.add();
                    }
                    case "remove_by_id":{
                        if(command.length==1){
                            System.out.println(" Вы не ввели параметр ");
                            break;
                        }
                        collectionManager.removeById(Long.parseLong(command[1]));
                    }
                    case "update_id":{
                        collectionManager.updateId(Long.parseLong(command[1]) ,new BandBuilder().create());
                    }
                    case "insert_at_index":{
                        if(command.length==1){
                            System.out.println(" Вы не ввели параметр ");
                            break;
                        }
                        collectionManager.insertAtIndex(Integer.parseInt(command[1]),new BandBuilder().create());
                    }
                    case "remove_lower":{
                        collectionManager.removeLower(new BandBuilder().create());
                    }
                    case "filter_starts_with_name":{
                        if(command.length==1){
                            System.out.println(" Вы не ввели параметр ");
                            break;
                        }
                        collectionManager.filterStartsWithName(command[1]);
                    }
                    case "count_less_than_genre":{
                        if(command.length==1){
                            System.out.println(" Вы не ввели параметр ");
                            break;
                        }
                        collectionManager.coutLessThanGanre(command[1]);
                    }
                    case "execute_script":{
                        if(command.length==1){
                            System.out.println(" Вы не ввели параметр ");
                            break;
                        }
                        collectionManager.executeScript();
                    }
                    default:
                        System.out.println(" Такой команды нет ");

                }
        }
    }
}



