package model.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Course {

    private String codiceInterno;
    private String nomeLiv;

    private String dataAtt;
    public Course(String codiceInterno, String NomeLiv, String dataAtt ) throws DateTimeParseException{
        this.setCodiceInterno(codiceInterno);
        this.setNomeLiv(NomeLiv);
        this.setDataAtt(dataAtt);
    }

    public void setCodiceInterno(String codiceInterno) {
        this.codiceInterno = codiceInterno;
    }

    public String getCodiceInterno() {
        return codiceInterno;
    }

    public void setDataAtt(String dataAtt) throws DateTimeParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate.parse(dataAtt, formatter);
        this.dataAtt = dataAtt;

    }

    public String getDataAtt() {
        return dataAtt;
    }

    public void setNomeLiv(String nomeLiv) {
        this.nomeLiv = nomeLiv;
    }

    public String getNomeLiv() {
        return nomeLiv;
    }
}
