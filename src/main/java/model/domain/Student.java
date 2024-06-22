package model.domain;

import exception.PhoneNumberFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    private String CF;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String indirizzoRes;

    private String numTelefono;

    private String dataIscrizione;

    private String codiceCorso;
    private String nomeLivello;

    public Student(String CF, String nome, String cognome, String dataNascita, String indirizzoRes, String numTelefono, String dataIscrizione,
                   String codiceCorso, String nomeLivello) throws DateTimeParseException
    {
        this.setCF(CF);
        this.setNome(nome);
        this.setCognome(cognome);
        this.setDataNascita(dataNascita);
        this.setIndirizzoRes(indirizzoRes);
        this.setNumTelefono(numTelefono);
        this.setDataIscrizione(dataIscrizione);
        this.setCodiceCorso(codiceCorso);
        this.setNomeLivello(nomeLivello);
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public String getCF() {
        return CF;
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

    public void setDataNascita(String dataNascita) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate.parse(dataNascita, formatter);
        this.dataNascita = dataNascita;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setIndirizzoRes(String indirizzoRes) throws DateTimeParseException {
        this.indirizzoRes = indirizzoRes;
    }

    public String getIndirizzoRes() {
        return indirizzoRes;
    }

    public void setNumTelefono(String numTelefono) throws PhoneNumberFormatException {
        String regexPattern = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(numTelefono);

        if(matcher.matches()) {
            this.numTelefono = numTelefono;
        }else throw new PhoneNumberFormatException();
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setDataIscrizione(String dataIscrizione) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate.parse(dataIscrizione, formatter);
        this.dataIscrizione = dataIscrizione;
    }

    public String getDataIscrizione() {
        return dataIscrizione;
    }

    public void setCodiceCorso(String codiceCorso) {
        this.codiceCorso = codiceCorso;
    }

    public String getCodiceCorso() {
        return codiceCorso;
    }

    public void setNomeLivello(String nomeLivello) {
        this.nomeLivello = nomeLivello;
    }

    public String getNomeLivello() {
        return nomeLivello;
    }
}
