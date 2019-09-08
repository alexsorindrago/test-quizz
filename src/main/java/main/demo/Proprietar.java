package main.demo;

public class Proprietar {
    public int cnp;
    public String adresa;

    public Proprietar(int cnp, String adresa) {
        this.cnp = cnp;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Proprietar{" +
                "cnp=" + cnp +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
