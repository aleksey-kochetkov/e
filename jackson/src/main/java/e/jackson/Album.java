package e.jackson;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Album {
    private String title;
    private String[] links;
    private List<String> songs = new ArrayList<>();
    private Artist artist;
    private Map<String, String> musicians = new HashMap<>();

    public Album() {
    }

    public Album(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    public String[] getLinks() {
        return this.links;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public List<String> getSongs() {
        return this.songs;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Map<String, String> getMusicians() {
        return Collections.unmodifiableMap(this.musicians);
    }

    public void setMusicians(Map<String, String> musicians) {
        this.musicians = musicians;
    }

    public void addMusician(String key, String value) {
        this.musicians.put(key, value);
    }
}
