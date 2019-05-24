package car.cardemo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String category;

    public long getId() {
        return id;
    }



    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

