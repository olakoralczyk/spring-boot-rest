package pl.dmcs.rkotas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Grade {
    @Id
    @GeneratedValue
    public long id;
    public double value;

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value =  value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
