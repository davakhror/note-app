package uz.rcs.fragments.models;

import java.util.ArrayList;
import java.util.List;

public class Note {
    String title;
    String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static List<Note> notesList() {
        List<Note> notesList = new ArrayList<>();

        notesList.add(
                new Note("Home",
                "A home, or domicile, is a space used " +
                "as a permanent or semi-permanent residence for one or more human occupants")
        );

        notesList.add(
                new Note("Work",
                "A home, or domicile, is a space used as a permanent or semi-permanent " +
                        "residence for one or more human occupants"));

        notesList.add(new Note("Office",
                "A home, or domicile, is a space used as a permanent or semi-permanent " +
                        "residence for one or more human occupants"));

        notesList.add(new Note("Remont",
                "A home, or domicile, is a space used as a permanent or semi-permanent " +
                        "residence for one or more human occupants"));
        return notesList;
    }

}
