package com.company;

public class Oceny {

    private Long id;
    private Integer wartosc;
    private Integer idStudent;
    private Integer idNauczyciel;

    public Oceny(Long id, Integer wartosc, Integer idStudent, Integer idNauczyciel) {
        this.id = id;
        this.wartosc = wartosc;
        this.idStudent = idStudent;
        this.idNauczyciel = idNauczyciel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWartosc() {
        return wartosc;
    }

    public void setWartosc(Integer wartosc) {
        this.wartosc = wartosc;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdNauczyciel() {
        return idNauczyciel;
    }

    public void setIdNauczyciel(Integer idNauczyciel) {
        this.idNauczyciel = idNauczyciel;
    }

    @Override
    public String toString() {
        return "Oceny{" +
                "id=" + id +
                ", wartosc=" + wartosc +
                ", idStudent=" + idStudent +
                ", idNauczyciel=" + idNauczyciel +
                '}';
    }
}
