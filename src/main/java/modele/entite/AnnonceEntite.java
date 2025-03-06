package modele.entite;

import java.time.LocalDate;

public class AnnonceEntite {


    private int id;
    private String title;
    private String description;
    private String mail;
    private LocalDate date;
    private String adresse;


    public AnnonceEntite(int id, String title, String description, String mail, String date, String adresse) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.mail = mail;
        this.date = LocalDate.now();
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getDate() {
        return date;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "AnnonceEntite{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", mail='" + mail + '\'' +
                ", date='" + date + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
