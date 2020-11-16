package building_procedure;

import console.ConsoleReader;
import object_of_collection.*;
import exceptions.*;

import java.io.IOException;
import java.time.ZonedDateTime;

public class BandBuilder implements IMusicBandBuilder, IMassages{

    private MusicBand musicBand;
    private BandCoordinatesBuilder bandCoordinateBuilder;
    private ConsoleReader consoleReader;

    public BandBuilder(){
        musicBand = new MusicBand();
        this.consoleReader = new ConsoleReader();
        this.bandCoordinateBuilder=new BandCoordinatesBuilder(consoleReader);

    }

    @Override
    public void setName() {
        while (true) {
            System.out.println("Выведите название музыкальной группы значение типа 'String' [не менее 3-х букв и не более 20-ти]");
            consoleReader.printDefaultConsoleSymbol();
            String readLine = consoleReader.getScanner().nextLine().trim();
            System.out.println(readLine);
            if (readLine.length() == 0) {
                System.out.println(messageOfEmptyFormatError);
                continue;
            }

            if (readLine.length() > 3 && readLine.length() < 20) {
                musicBand.setName((readLine).trim());
                break;
            } else
                System.out.println(messageOfInputValueError);
        }
    }

    @Override
    public void setCoordinates() {musicBand.setCoordinates(bandCoordinateBuilder.create());
    }

    @Override
    public void setNumberOfParticipants() {
        while (true) {
            System.out.println("Введите колличество участников музыкальной группы");
            consoleReader.printDefaultConsoleSymbol();
            try {
                String readLine = consoleReader.getScanner().nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if (readLine.length() > 3) {
                    System.out.println(messageOfInputValueError);
                    continue;
                }

                int parsedLine = Integer.parseInt(readLine);
                    musicBand.setNumberOfParticipants(Integer.parseInt(readLine));
                    break;
            } catch(NumberFormatException e){
                System.out.println(messageOfInputValueError);
            }
        }
    }

    @Override
    public void setGenre() {
        while (true) {
        System.out.println("Выберите жанр для группы из доступных: ");
        MusicGenre.printAllGenres();
        System.out.println("Для этого введите соответствующий порядковый номер");
        consoleReader.printDefaultConsoleSymbol();
            try {
        String readLine = consoleReader.getScanner().nextLine().trim();
                if (readLine.length() == 0) {
                    System.out.println(messageOfEmptyFormatError);
                    continue;
                }

                if (Integer.parseInt(readLine.trim()) == MusicGenre.POP.getNumber()) {
                    musicBand.setGenre(MusicGenre.POP);
                    System.out.println("Жарн группы успешно выбран: " + musicBand.getGenre().getName());
                    break;
                } else if (Integer.parseInt(readLine.trim()) == MusicGenre.RAP.getNumber()) {
                    musicBand.setGenre(MusicGenre.RAP);
                    System.out.println("Жарн группы успешно выбран: " + musicBand.getGenre().getName());
                    System.out.println("¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n" +
                            "¶____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶____________¶¶\n" +
                            "¶______________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_____________¶\n" +
                            "¶¶¶____¶¶¶_____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶___¶¶¶¶____¶\n" +
                            "¶¶¶____¶¶¶_____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶___¶¶¶¶____¶\n" +
                            "¶¶¶____¶¶¶____¶¶¶¶¶________¶¶¶¶¶¶___¶¶¶¶____¶\n" +
                            "¶¶¶__________¶¶¶¶¶_________¶¶¶¶¶¶__________¶¶\n" +
                            "¶¶¶___________¶¶¶¶___¶¶¶___¶¶¶¶¶¶________¶¶¶¶\n" +
                            "¶¶¶____¶¶¶¶___¶¶¶¶___¶¶¶___¶¶¶¶¶¶_____¶¶¶¶¶¶¶\n" +
                            "¶¶¶____¶¶¶¶____¶¶¶___¶¶¶___¶¶¶¶¶¶_____¶¶¶¶¶¶¶\n" +
                            "¶______¶¶¶______¶¶___________¶¶_________¶¶¶¶¶\n" +
                            "¶______¶¶¶______¶¶¶______¶___¶¶_________¶¶¶¶¶\n" +
                            "¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n");
                    break;
                } else if (Integer.parseInt(readLine.trim()) == MusicGenre.ROCK.getNumber()) {
                    musicBand.setGenre(MusicGenre.ROCK);
                    System.out.println("Жарн группы успешно выбран: " + musicBand.getGenre().getName());
                    System.out.println("\n" +
                            " `$   `$,   `$,    d;     ,  НАШ ДЕДУШКА ЛЕНИН-ПАНК! \n" +
                            "`$b,  `$,   $$,  d$'   ,$ \n" +
                            "`$$  l$  ;$$ d$$   ,$'    , \n" +
                            "`$$b,;$$b,$$$$$$; ,d$$   ,$ \n" +
                            "`$$$b$$$$$$$$$$$$$$$; ,d$' \n" +
                            " `$$$*\"\"\"\"~~\"\"^L$$$$$$$$P    ,, \n" +
                            " *^              ~^\"$$$$;_,s$' \n" +
                            ",^                    `$$$$$$'    _ \n" +
                            ",'                       `$$$'  ,y$\" \n" +
                            "'                         `$$,y$$\" \n" +
                            "(                           `$$$$' \n" +
                            ",^       ,,,         ууууyyyyyууу$$$$$#=- \n" +
                            "`\\,  ,,/'^  ``      `$$$$$$$$$$d;$$$~ \n" +
                            "/' ,$$*=``-     `$b`?$$$$$$$$$$;$$$b, \n" +
                            ",'   `^*;-=''    `$$$$$$$#$$$$$$$;$$$L$b. \n" +
                            "(,,,;,             `L$-\",гy`?$$$$;$b, \n" +
                            "`;``\"                 ]$& $';$$$$d$$$b, \n" +
                            ",yyy,,                •@@&`'d$$$$d$P\"\"L$, \n" +
                            "\\?`^\"$@by,            ~L>^,$$$$$d$$b, \n" +
                            ",&~`^\"L?~#`        ,yb, ,?$$$$$d$$$$b, \n" +
                            "'   $    ,      ,,yd$$$$$=+=$$$d$$~~\"L; \n" +
                            "/   '$, $$$yyyyy$$$$$\" ,$$$•$$$d$$$b, \n" +
                            "`-=##$$$$$$$$$$$$$$^~  ,$$$$$ \n");
                    break;
                } else if (Integer.parseInt(readLine.trim()) == MusicGenre.POST_PUNK.getNumber()) {
                    musicBand.setGenre(MusicGenre.POST_PUNK);
                    System.out.println("Жарн группы успешно выбран: " + musicBand.getGenre().getName());
                    break;
                } else if (Integer.parseInt(readLine.trim()) == MusicGenre.PSYCHEDELIC_ROCK.getNumber()) {
                    musicBand.setGenre(MusicGenre.PSYCHEDELIC_ROCK);
                    System.out.println("Жарн группы успешно выбран: " + musicBand.getGenre().getName());
                    break;
                }else if (Integer.parseInt(readLine.trim()) == MusicGenre.JAZZ.getNumber()) {
                    musicBand.setGenre(MusicGenre.JAZZ);
                    System.out.println("Жарн группы успешно выбран: " + musicBand.getGenre().getName());
                    break;
                }
                else {
                    System.out.println(System.lineSeparator() + messageOfInputFormatError);

                }
            }catch (NumberFormatException e) {
                System.out.println(messageOfInputFormatError);
            }
        }
    }

    @Override
    public void setLabel() {
        while (true) {
            System.out.println("Введите название лейбла группы");
            consoleReader.printDefaultConsoleSymbol();
            String readLine = consoleReader.getScanner().nextLine().trim();
            if (readLine.length() == 0) {
                System.out.println(messageOfEmptyFormatError);
                continue;
            }
            musicBand.setLabel(readLine);
            break;
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
        System.out.println("Группа была успешно создана");
        return musicBand;

    }

    public MusicBand getMusicBand(){
        return musicBand;
    }
}
