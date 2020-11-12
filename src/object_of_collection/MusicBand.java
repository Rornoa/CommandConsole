package object_of_collection;

import java.time.ZonedDateTime;

public class MusicBand implements Comparable<MusicBand> {
    static long ID = 1;
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long numberOfParticipants; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле не может быть null
    private Label label; //Поле не может быть null

    public MusicBand(String name, Coordinates coordinates, long numberOfParticipants, MusicGenre genre, Label label) {
        this.id = ID++;
        assert id > 0 : "Ошибка генератора уникальный id";
        this.name = name;
        assert name != null : "Поле 'Имя' не можнт быть null";
        assert !"".equals(name) : "Поле 'Имя' не может быть строкой";
        this.coordinates = coordinates;
        assert coordinates != null : "Поле 'координаты не может быть null";
        this.creationDate = ZonedDateTime.now();
        this.numberOfParticipants = numberOfParticipants;
        assert numberOfParticipants > 0 : "Поле 'Колличество участников' не может быть меньше нуля";
        this.genre = genre;
        assert genre != null : "Поле 'жанр' не может быть null";
        this.label = label;
        assert label != null : "Поле 'лейбл' не может быть null";
    }

    public MusicBand(){

    }

    public MusicBand(Long id, String name, Coordinates coordinates, ZonedDateTime creationDate, long numberOfParticipants, MusicGenre genre, Label label) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.genre = genre;
        this.label = label;
        System.out.println("Музыкальная группа "+name + " успешно инициализирована.");
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public Long getId() {
        return id; }

    public Label getLabel() {
        return label;
    }

    public void setId(Long id) {
        this.id = id; }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setNumberOfParticipants(long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public void setLabel(String label) {

        this.label =new Label(label);
    }

    @Override
    public int compareTo(MusicBand o) {
        return this.creationDate.compareTo(o.creationDate);
    }
}


