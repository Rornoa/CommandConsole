package building_procedure;

import console.ConsoleReader;
import object_of_collection.*;

import java.time.ZonedDateTime;

public class BandBuilder implements IMusicBandBuilder{

    private String name = "Deafult";
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private long numberOfParticipants;
    private Label label;
    private BandCoordinatesBuilder bandCoordinateBuilder;
    private ConsoleReader consoleReader;
    private MusicGenre musicGenre;

    public BandBuilder(){
        this.bandCoordinateBuilder = new BandCoordinatesBuilder();
        this.consoleReader = new ConsoleReader();
    }

    @Override
    public void setName(){
        System.out.println("Выведите название музыкальной группы");
        consoleReader.printDefaultConsoleSymbol();
        String line = consoleReader.getScanner().nextLine().trim();
        try{
            if(line.length() >3 && line.length()<20 ){
                name = (line).trim();
            }
            else{System.out.println("Название группы не может быть меньше 3 символов или больше 20 символов");
                setName();}

        }catch(Exception e){
            System.out.println("Название группы не может быть меньше 3 символов или больше 20 символов");
            setName();
        }
    }

    @Override
    public void setCoordinates() {coordinates = bandCoordinateBuilder.create();
    }

    @Override
    public void setNumberOfParticipants() {
        System.out.println("Введите колличество участников музыкальной группы");
        consoleReader.printDefaultConsoleSymbol();
        String line = consoleReader.getScanner().nextLine().trim();
        while (true) {
            if (Integer.parseInt(line) > 0 && Integer.parseInt(line) < Integer.MAX_VALUE) {
                numberOfParticipants = Integer.parseInt(line);
                break;
            } else System.out.println("Вы ввели неправильное значение для поля колличество участников группы");
        }
    }

    @Override
    public void setGenre() {
        System.out.println("Выберите жанр для группы из доступных: ");
        MusicGenre.printAllGenres();
        System.out.println("Для этого введите соответствующий порядковый номер");
        consoleReader.printDefaultConsoleSymbol();
        String line = consoleReader.getScanner().nextLine().trim();
        while(true) {
            if (Integer.parseInt(line.trim()) == MusicGenre.POP.getNumber()) {
                musicGenre = MusicGenre.POP;
                System.out.println("Тип уровня жизни в городе успешно выбран: " + musicGenre.getName());
                break;
            } else if(Integer.parseInt(line.trim()) == MusicGenre.RAP.getNumber()){
                musicGenre = MusicGenre.RAP;
                System.out.println("Тип уровня жизни в городе успешно выбран: " + musicGenre.getName());
                break;
            } else if(Integer.parseInt(line.trim()) == MusicGenre.ROCK.getNumber()){
                musicGenre = MusicGenre.ROCK;
                System.out.println("Тип уровня жизни в городе успешно выбран: " + musicGenre.getName());
                break;
            } else if(Integer.parseInt(line.trim()) == MusicGenre.POST_PUNK.getNumber()){
                musicGenre = MusicGenre.POST_PUNK;
                System.out.println("Тип уровня жизни в городе успешно выбран: " + musicGenre.getName());
                break;
            } else if(Integer.parseInt(line.trim()) == MusicGenre.PSYCHEDELIC_ROCK.getNumber()){
                musicGenre = MusicGenre.PSYCHEDELIC_ROCK;
                System.out.println("Тип уровня жизни в городе успешно выбран: " + musicGenre.getName());
                break;
            } else{
                System.out.println(System.lineSeparator()+"Вы должны ввести только порядковый номер жанра для группы");
            }
        }
    }

    @Override
    public void setLabel() {
        System.out.println("Введите название лейбла группы");
        consoleReader.printDefaultConsoleSymbol();
        String line = consoleReader.getScanner().nextLine().trim();
        while (true){
         if(line.length()!=0) {
              label.name= line;
             break;
         }else{
             System.out.println("Вы ничего не ввели, попробуйте снова");
             }
        }
    }

    @Override
    public MusicBand create() {
        System.out.println(System.lineSeparator()+"Начинается инициализация группы:");
        setName();
        setCoordinates();
        setNumberOfParticipants();
        setGenre();
        setLabel();
        return new MusicBand(name, coordinates,numberOfParticipants, musicGenre,label);
    }

    public MusicBand getMusicBand(){
        return new MusicBand(name ,coordinates ,numberOfParticipants ,musicGenre ,label);
    }
}
