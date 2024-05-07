package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "userprofile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userprofile_gen")
    @SequenceGenerator(
            name = "userprofile_gen",
            sequenceName = "userprofile_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String registration_date;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.DETACH})
    private UserDetails userDetails;

    public UserProfile(String userName, String email, String registration_date) {
        this.userName = userName;
        this.email = email;
        this.registration_date = registration_date;
    }

    public UserProfile(String userName, String email, String registration_date, UserDetails userDetails) {
        this.userName = userName;
        this.email = email;
        this.registration_date = registration_date;
        this.userDetails = userDetails;
    }
}