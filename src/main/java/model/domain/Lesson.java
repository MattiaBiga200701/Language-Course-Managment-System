package model.domain;

import exception.TimeFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson {

    private String dataLez;
    private String ora;

    private String codiceCorso;

    private String nomeLiv;
    private String nomeIns;
    private String cognomeIns;


    public Lesson(String dataLez, String ora, String codiceCorso, String nomeLiv, String nomeIns, String cognomeIns ) throws DateTimeParseException, TimeFormatException{

        this.setDataLez(dataLez);
        this.setOra(ora);
        this.setCodiceCorso(codiceCorso);
        this.setNomeLiv(nomeLiv);
        this.setNomeIns(nomeIns);
        this.setCognomeIns(cognomeIns);

    }

    public void setDataLez(String dataLez) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dataLez, formatter);
        this.dataLez = dataLez;
    }

    public String getDataLez() {
        return dataLez;
    }

    public void setOra(String ora) throws TimeFormatException{
        String TIME_PATTERN = "^([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
        Pattern pattern = Pattern.compile(TIME_PATTERN);
        Matcher matcher = pattern.matcher(ora);

        if(matcher.matches()) {
            this.ora = ora;
        }else throw new TimeFormatException();

    }

    public void setCodiceCorso(String codiceCorso) {
        this.codiceCorso = codiceCorso;
    }

    public String getCodiceCorso() {
        return codiceCorso;
    }

    public String getOra() {
        return ora;
    }

    public void setNomeLiv(String nomeLiv) {
        this.nomeLiv = nomeLiv;
    }

    public String getNomeLiv() {
        return nomeLiv;
    }

    public void setNomeIns(String nomeIns) {
        this.nomeIns = nomeIns;
    }

    public String getNomeIns() {
        return nomeIns;
    }

    public void setCognomeIns(String cognomeIns) {
        this.cognomeIns = cognomeIns;
    }

    public String getCognomeIns() {
        return cognomeIns;
    }
}
