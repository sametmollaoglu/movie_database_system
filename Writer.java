public class Writer extends Artist {
    public String wStyle;

    public Writer(int ID, String name, String surName, String country, String wStyle) {
        super(ID, name, surName, country);
        this.wStyle = wStyle;
    }
}
