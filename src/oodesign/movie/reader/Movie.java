package oodesign.movie.reader;

public class Movie {
    int ID;
    String NAME;
    String YEAR;

    Movie(int id, String name, String year) {
        this.ID = id;
        this.NAME = name;
        this.YEAR = year;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String name) {
        this.NAME = name;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String year) {
        this.YEAR = year;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
