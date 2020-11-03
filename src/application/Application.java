package application;

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
            try {
                String[] command = readAndParse();
                    if(command[0].equals("help")||
                        command[0].equals("info")||
                        command[0].equals("show")||
                        command[0].equals("clear")||
                        command[0].equals("save")||
                        command[0].equals("remove_first")||
                        command[0].equals("exit")||
                        command[0].equals("print_field_ascending_label")||
                        command[0].equals("add")||
                        command[0].equals("remove_by_id")||
                        command[0].equals("update_id")||
                        command[0].equals("insert")||
                        command[0].equals("remove_lower")||
                        command[0].equals("filter_starts_with_name")||
                        command[0].equals("cout_less_than_ganre")||
                        command[0].equals("execute_script")){

                    if(command[0].equals("show")||command[0].equals("info")||command[0].equals("help")||command[0].equals("exit")||command[0].equals("remove_first")||command[0].equals("clear")||command[0].equals("save")||command[0].equals("print_field_ascending_label")){
                        switch(command[0]){
                            case "show": collectionManager.show(); break;
                            case "info": collectionManager.info(); break;
                            case "help": collectionManager.help(); break;
                            case "clear": collectionManager.clear(); break;
                            case "save": collectionManager.save(); break;
                            case "remove_first": collectionManager.removeFirst(); break;
                            case "exit": collectionManager.exit(); break;
                        }
                    }
                }
               }
                catch(NoSuchElementException e){
              }
            }
        }

    private String[] readAndParse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВведите команду");
        String command="";

        do command = command+scanner.nextLine();
        while ((command.length()-command.replaceAll("}","").length())>(command.length()-command.replaceAll("\\{","").length()));
        command = command.trim();

        String[] fullCommand;
        if (!command.split(" ",2)[0].equals("insert")) {
            fullCommand=command.split(" ",2);
            if (fullCommand.length>1) while (fullCommand[1].contains("  ")) fullCommand[1]=fullCommand[1].replaceAll("  "," ");
            if (fullCommand[0].equals("remove"))
                fullCommand[1]=fullCommand[1].replaceAll(" ","");}
        //если insert
        else{if (command.split(" ",3).length<3)
            fullCommand=command.split(" ",2);
        else{  fullCommand =command.split(" ",3); while (fullCommand[1].contains("  ")) fullCommand[1]=fullCommand[1].replaceAll("  "," ");}
        } return fullCommand;

    }

}



