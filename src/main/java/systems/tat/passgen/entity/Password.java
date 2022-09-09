package systems.tat.passgen.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "password")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "pass_id", nullable = false)),
        @AttributeOverride(name = "applicationName", column = @Column(name = "pass_application_name", nullable = false)),
        @AttributeOverride(name = "creationDate", column = @Column(name = "pass_creation", nullable = false)),
        @AttributeOverride(name = "lastModificationDate", column = @Column(name = "pass_last_modification", nullable = false))
})
public class Password {

    @Id
    @SequenceGenerator(name = "password_seq", sequenceName = "password_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "password_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn( name = "cli_id", referencedColumnName = "clientId")
    private Client owner;

    @NotBlank(message = "Please insert a Password")
    private String applicationName;

    private Long creationDate;

    private Long lastModificationDate;
}
