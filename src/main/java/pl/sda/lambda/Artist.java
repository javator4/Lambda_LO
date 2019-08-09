package pl.sda.lambda;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Artist {
    private String name;
    private List<Artist> members;
    private String nationality;

    public Artist(String name, List<Artist> members, String nationality) {
        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
    }
    public Artist(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }
}
