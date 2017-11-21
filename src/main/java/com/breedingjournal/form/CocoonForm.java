package com.breedingjournal.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Roman on 2017-10-07.
 */
public class CocoonForm {
    @NotNull(message = "nie moze byc puste")
    private Long cocoonNumber;
    @Past
    @NotNull(message = "nie moze byc puste")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cocoonPlaceDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cocoonHatchDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date cocoonTransferDate;
    private String comments;

    public CocoonForm() {
    }

    public CocoonForm(Long cocoonNumber, Date cocoonPlaceDate, Date cocoonHatchDate, Date cocoonTransferDate, String comments) {
        this.cocoonNumber = cocoonNumber;
        this.cocoonPlaceDate = cocoonPlaceDate;
        this.cocoonHatchDate = cocoonHatchDate;
        this.cocoonTransferDate = cocoonTransferDate;
        this.comments = comments;
    }

    public Long getCocoonNumber() {
        return cocoonNumber;
    }

    public void setCocoonNumber(Long cocoonNumber) {
        this.cocoonNumber = cocoonNumber;
    }

    public Date getCocoonPlaceDate() {
        return cocoonPlaceDate;
    }

    public void setCocoonPlaceDate(Date cocoonPlaceDate) {
        this.cocoonPlaceDate = cocoonPlaceDate;
    }

    public Date getCocoonHatchDate() {
        return cocoonHatchDate;
    }

    public void setCocoonHatchDate(Date cocoonHatchDate) {
        this.cocoonHatchDate = cocoonHatchDate;
    }

    public Date getCocoonTransferDate() {
        return cocoonTransferDate;
    }

    public void setCocoonTransferDate(Date cocoonTransferDate) {
        this.cocoonTransferDate = cocoonTransferDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
