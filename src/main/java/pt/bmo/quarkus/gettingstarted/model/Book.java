package pt.bmo.quarkus.gettingstarted.model;

public record Book(
        int id,
        String title,
        String author,
        int yearOfPublication,
        String genre
) { }
