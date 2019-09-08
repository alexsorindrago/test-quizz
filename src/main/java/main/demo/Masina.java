package main.demo;

public class Masina {
    public String id;
    public String culoare;
    public String marca;
    public int cnp_proprietar;

    public Masina(String id, String culoare, String marca, int cnp_proprietar) {
        this.id = id;
        this.culoare = culoare;
        this.marca = marca;
        this.cnp_proprietar = cnp_proprietar;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "id='" + id + '\'' +
                ", culoare='" + culoare + '\'' +
                ", marca='" + marca + '\'' +
                ", cnp_proprietar=" + cnp_proprietar +
                '}';
    }


}
