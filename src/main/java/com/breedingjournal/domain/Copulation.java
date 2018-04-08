package com.breedingjournal.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Created by Roman on 2017-09-12.
 */
@Entity
public class Copulation {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private Date copulationDate;
    private Integer femaleNumber;
    private Integer maleNumber;
    @OneToMany(mappedBy = "copulation",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Cocoon> cocoonList;


    public Copulation(Date copulationDate, int femaleNumber, int maleNumber) {
        this.copulationDate = copulationDate;
        this.femaleNumber = femaleNumber;
        this.maleNumber = maleNumber;

    }
    public Copulation(int femaleNumber, int maleNumber) {

        this.femaleNumber = femaleNumber;
        this.maleNumber = maleNumber;

    }
    public Copulation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Cocoon> getCocoonList() {
        return cocoonList;
    }

    public void setCocoonList(List<Cocoon> cocoonList) {
        this.cocoonList = cocoonList;
    }
}
