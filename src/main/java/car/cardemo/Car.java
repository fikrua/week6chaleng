package car.cardemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String manufacturer;
    private String model;
    private int year;
    private double msrm;
    private int catagoryid;
    private String headshot;

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMsrm() {
        return msrm;
    }

    public void setMsrm(double msrm) {
        this.msrm = msrm;
    }

    public int getCatagoryid() {
        return catagoryid;
    }

    public void setCatagoryid(int catagoryid) {
        this.catagoryid = catagoryid;
    }
}
