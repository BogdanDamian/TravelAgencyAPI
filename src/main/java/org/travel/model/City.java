package org.travel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;
    private String name;
    private Boolean isDestination;

    @ManyToOne
    @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "COUNTRY_CITY_FK"))
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "fromCity")
    private List<Road> roadsFrom;

    @OneToMany(mappedBy = "toCity")
    private List<Road> roadsTo;
}
