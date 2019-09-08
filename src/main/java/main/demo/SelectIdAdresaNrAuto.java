package main.demo;

public class SelectIdAdresaNrAuto {
    public int id;
    public String culoare;
    public String marca;

    public SelectIdAdresaNrAuto(int id, String culoare, String marca) {
        this.id = id;
        this.culoare = culoare;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "SelectIdAdresaNrAuto{" +
                "id=" + id +
                ", culoare='" + culoare + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}

