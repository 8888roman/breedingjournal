package com.breedingjournal.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Roman on 2017-09-12.
 */
@Entity
public class Cocoon {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JoinColumn(name = "cocoon_ID")
    private long id;
    @ManyToOne
    private Copulation copulation;
    @NotNull
    private int cocoonNumber;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cocoonPlaceDate;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cocoonHatchDate;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cocoonTransferDate;
    private String comments;

    public Cocoon() {
    }

    public Cocoon(Copulation copulation, int cocoonNumber, Date cocoonPlaceDate, Date cocoonHatchDate, Date cocoonTransferDate, String comments) {
        this.copulation = copulation;
        this.cocoonNumber = cocoonNumber;
        this.cocoonPlaceDate = cocoonPlaceDate;
        this.cocoonHatchDate = cocoonHatchDate;
        this.cocoonTransferDate = cocoonTransferDate;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Copulation getCopulation() {
        return copulation;
    }

    public void setCopulation(Copulation copulation) {
        this.copulation = copulation;
    }

    public int getCocoonNumber() {
        return cocoonNumber;
    }

    public void setCocoonNumber(int cocoonNumber) {
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
