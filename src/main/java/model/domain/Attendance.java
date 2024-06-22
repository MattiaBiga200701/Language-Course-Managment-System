package model.domain;

import exception.TimeFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Attendance {

    private String studente;
    private String dataLez;
    private String oraLez;
    private String codiceCorso;
    private String nomeLiv;

    public Attendance(String studente, String dataLez, String oraLez, String codiceCorso, String nomeLiv) throws DateTimeParseException, TimeFormatException{
        this.setStudente(studente);
        this.setDataLez(dataLez);
        this.setOraLez(oraLez);
        this.setCodiceCorso(codiceCorso);
        this.setNomeLiv(nomeLiv);
    }

    public void setStudente(String studente) {
        this.studente = studente;
    }

    public String getStudente() {
        return studente;
    }

    public void setDataLez(String dataLez) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate.parse(dataLez, formatter);
        this.dataLez = dataLez;
    }

    public String getDataLez() {
        return dataLez;
    }

    public void setOraLez(String oraLez) throws TimeFormatException {

        String TIME_PATTERN = "^([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
        Pattern pattern = Pattern.compile(TIME_PATTERN);
        Matcher matcher = pattern.matcher(oraLez);
        if(matcher.matches()) {
            this.oraLez = oraLez;
        } else throw new TimeFormatException();
    }

    public String getOraLez() {
        return oraLez;
    }

    public void setCodiceCorso(String codiceCorso) {
        this.codiceCorso = codiceCorso;
    }

    public String getCodiceCorso() {
        return codiceCorso;
    }

    public void setNomeLiv(String nomeLiv) {
        this.nomeLiv = nomeLiv;
    }

    public String getNomeLiv() {
        return nomeLiv;
    }
}
