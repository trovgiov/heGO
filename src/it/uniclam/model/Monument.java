package it.uniclam.model;

/**
 * Created by GiovanniTrovini on 03/05/17.
 */
public class Monument {
    private int id_monument;
    private String monument;
    private int progress;

    public int getProgress() {
        return progress;
    }

    public Monument(int id_monument, String monument, int progress) {
        this.id_monument = id_monument;
        this.monument = monument;
        this.progress = progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Monument(String monument) {
        this.monument = monument;
    }

    public int getId_monument() {
        return id_monument;
    }

    public Monument(int id_monument, String monument) {
        this.id_monument = id_monument;
        this.monument = monument;
    }

    public void setId_monument(int id_monument) {
        this.id_monument = id_monument;
    }

    public String getMonument() {
        return monument;
    }

    public void setMonument(String monument) {
        this.monument = monument;
    }
}
