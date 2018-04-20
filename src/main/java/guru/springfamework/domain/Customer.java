package guru.springfamework.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by rubatsirochiripa on 3/4/2018.
 */
@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
}
