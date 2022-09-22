package com.uniyaz.entity;

import javax.persistence.*;

@Entity
@Table(name = "SUBE")
public class Sube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subeAdi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SIRKET",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_SUBE_SIRKET_ID")
    )
    private Sirket sirket;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubeAdi() {
        return subeAdi;
    }

    public void setSubeAdi(String subeAdi) {
        this.subeAdi = subeAdi;
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }
}
