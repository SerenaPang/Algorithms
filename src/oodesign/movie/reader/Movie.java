package oodesign.movie.reader;

public class Movie {
    int id;
    String name;
    String year;

    Movie(int id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return this.id + " " + this.name + " " + this.year;
    }
}
