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
public class Road {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "from_city_id", foreignKey = @ForeignKey(name = "CITY_FROM_FK"))
    private City fromCity;

    @ManyToOne
    @JoinColumn(name = "to_city_id", foreignKey = @ForeignKey(name = "CITY_TO_FK"))
    private City toCity;

    @OneToMany(mappedBy = "road")
    private List<Trip> trips;
}
