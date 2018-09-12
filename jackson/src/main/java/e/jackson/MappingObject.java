package e.jackson;

import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MappingObject {
    private Album album;

    public static void main(String[] args) {
        new MappingObject().init().run();
    }

    public MappingObject init() {
        this.album = new Album("King of Blue");
        this.album.setLinks(new String[] {"Link one", "Link two"});
        List<String> songs = new ArrayList<>();
        songs.add("So What");
        songs.add("Flamenco Sketches");
        songs.add("Freddie Freeloader");
        this.album.setSongs(songs);
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Artist artist = new Artist("Miles Davis",
                                             format.parse("26-05-1926"));
            this.album.setArtist(artist);
        } catch (ParseException exception) {
            throw new RuntimeException(exception);
        }
        this.album.addMusician("Miles Davis", "Trumpet, Band leader");
        this.album.addMusician("Julian Adderley", "Alto Saxophone");
        this.album.addMusician("Paul Chambers", "double bass");
        return this;
    }

    public void run() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(System.out, this.album);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        this.album = null;
        String json = "{\"title\":\"Nevermind\",\"links\":[\"Link one\",\"Link two\"],"
          + "\"songs\":[\"Smells Like Teenspirit\",\"In bloom\",\"Come As You Are\"],"
          + "\"artist\":{\"name\":\"Kurt Cobain\",\"birthDate\":-1376013600000},"
          + "\"musicians\":{\"Kurt Cobain\":\"Vocal, Guitar\",\"Crist Novoselich\":\"double bass\",\"Dave Grohl\":\"Drums\"}}";
        try {
            this.album = mapper.readValue(json, Album.class);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
