import jakarta.persistence.*;

import java.util.List;

@Entity
public class Laptop {

    @Id
    private int lid;
    private String brand;
    private int ram;

    @ManyToMany(mappedBy = "laptop")
    private List<Alien> alien;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public List<Alien> getAlien() {
        return alien;
    }

    public void setAlien(List<Alien> alien) {
        this.alien = alien;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", ram=" + ram +
                '}';
    }
}
