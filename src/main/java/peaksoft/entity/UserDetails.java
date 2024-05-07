package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "userdetails")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userdetails_gen")
    @SequenceGenerator(
            name = "userdetails_gen",
            sequenceName = "userdetails_seq",
            allocationSize = 1
    )
    private Long id;
    private String full_name;
    private LocalDate date_of_birth;
    private String address;
    @OneToOne(mappedBy = "userDetails", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE})
    private UserProfile profile;

    public UserDetails(String full_name, LocalDate date_of_birth, String address) {
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", address='" + address + '\'' +
                '}';
    }
}