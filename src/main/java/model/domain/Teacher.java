package model.domain;

public class Teacher {

    private String nome;
    private String cognome;
    private String nazione;
    private String indirizzoRes;

    public Teacher(String nome, String cognome, String nazione, String indirizzoRes) {

        this.setNome(nome);
        this.setCognome(cognome);
        this.setNazione(nazione);
        this.setIndirizzoRes(indirizzoRes);

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getNazione() {
        return nazione;
    }

    public void setIndirizzoRes(String indirizzoRes) {
        this.indirizzoRes = indirizzoRes;
    }

    public String getIndirizzoRes() {
        return indirizzoRes;
    }
}
