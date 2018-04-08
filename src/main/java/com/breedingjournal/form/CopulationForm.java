package com.breedingjournal.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Roman on 2017-09-12.
 */
public class CopulationForm {
    @Past
    @NotNull(message = "Wybierz datę kopulacji")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date copulationDate;
    @NotNull(message = "Wpisz nr samicy")
    private Integer femaleNumber;
    @NotNull(message = "Wpisz nr samca")
    private Integer maleNumber;

    public CopulationForm(Date copulationDate, int femaleNumber, int maleNumber) {
        this.copulationDate = copulationDate;
        this.femaleNumber = femaleNumber;
        this.maleNumber = maleNumber;
    }

    public CopulationForm(int femaleNumber, int maleNumber) {

        this.femaleNumber = femaleNumber;
        this.maleNumber = maleNumber;
    }

    public CopulationForm() {
    }

    public Date getCopulationDate() {
        return copulationDate;
    }

    public void setCopulationDate(Date copulationDate) {
        this.copulationDate = copulationDate;
    }

    public Integer getFemaleNumber() {
        return femaleNumber;
    }

    public void setFemaleNumber(Integer femaleNumber) {
        this.femaleNumber = femaleNumber;
    }

    public Integer getMaleNumber() {
        return maleNumber;
    }

    public void setMaleNumber(Integer maleNumber) {
        this.maleNumber = maleNumber;
    }
}

