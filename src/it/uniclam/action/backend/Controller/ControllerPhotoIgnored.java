package it.uniclam.action.backend.Controller;

import com.opensymphony.xwork2.Action;
import it.uniclam.action.backend.Crud.CrudDao_Photo_ignored;
import it.uniclam.model.PhotoView;

import java.sql.Date;
import java.util.List;

/**
 * BACKEND :
 * Consente la creazione di una lista di tutte le foto ignorate
 */
public class ControllerPhotoIgnored {
    private CrudDao_Photo_ignored dao = new CrudDao_Photo_ignored();

    private List<PhotoView> records;
    private String result;
    private String message;

    private int idPhoto;
    private String titolo;
    private Date today;
    private String nome;
    private String cognome;

    public CrudDao_Photo_ignored getDao() {
        return dao;
    }

    public void setDao(CrudDao_Photo_ignored dao) {
        this.dao = dao;
    }

    public List<PhotoView> getRecords() {
        return records;
    }

    public void setRecords(List<PhotoView> records) {
        this.records = records;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMonumento() {
        return monumento;
    }

    public void setMonumento(String monumento) {
        this.monumento = monumento;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    private String monumento;

    private String stato;

    private boolean IsActive;

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public String list(){
        try{
            records=dao.getAllPhotos_ign();
            result="OK";
        }

        catch(Exception e){
            result="ERROR";
        }
        return Action.SUCCESS;
    }


}
