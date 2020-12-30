package com.myaudiolibrary.ipi.exception;


import com.myaudiolibrary.ipi.model.Artist;

public class ArtistException extends Throwable {
    public static final String ID = "L'identifiant ne correspond pas à celui de l'artist";

    public ArtistException(String message, Artist artist, Object valeurIncorrecte) {
        super(message + valeurIncorrecte + ", artist : " + artist.toString());
        System.out.println(this.getMessage());
    }

    public ArtistException(String message) {
        super(message);
        System.out.println(this.getMessage());
    }
}