package pl.sda.lambda;

import lombok.Data;

@Data
public class Track {
    private String name;
    private int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }
}
