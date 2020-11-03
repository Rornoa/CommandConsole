package object_of_collection;

public enum MusicGenre {
    PSYCHEDELIC_ROCK("Психоделический рок", 1),
    RAP("Рэп",2),
    POP("Попса",3),
    POST_PUNK("Пост-панк",4),
    ROCK("Рок",5);

    private String name;
    final private int number;

    MusicGenre(String russianName, int number) {
        this.name = russianName;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static void printAllGenres(){
        System.out.println(PSYCHEDELIC_ROCK.getNumber()+ " - " + PSYCHEDELIC_ROCK.getName()+ System.lineSeparator()
                        + RAP.getNumber()+ " - " + RAP.getName() + System.lineSeparator()
                        + POP.getNumber() + " - " + POP.getName() + System.lineSeparator()
                        + POST_PUNK.getNumber() + " - " + POST_PUNK.getNumber() + System.lineSeparator()
                        + ROCK.getNumber() + " - " + ROCK.getName() + System.lineSeparator());
    }

}
