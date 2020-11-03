package building_procedure;

import object_of_collection.MusicBand;

public interface IMusicBandBuilder {

    void setName();

    void setCoordinates();

    void setNumberOfParticipants();

    void setGenre();

    void setLabel();

    MusicBand create();
}
