package mk.ukim.finki.fuelsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Float latitude;

    private Float longitude;
    private String imageUrl;
    private String pageLink;

    public Fuel(String name, Float latitude, Float longitude, String imageUrl, String pageLink) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
        this.pageLink = pageLink;
    }

    public Long getId() {
        return id;
    }
}
