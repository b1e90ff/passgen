package systems.tat.passgen.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "client", uniqueConstraints = @UniqueConstraint(name = "clientId", columnNames = "cli_id"))
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "clientId", column = @Column(name = "cli_id", nullable = false)),
        @AttributeOverride(name = "creationDate", column = @Column(name = "cli_creation_date", nullable = false))
})
public class Client {

    @Id
    @SequenceGenerator(name = "cli_seq", sequenceName = "cli_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cli_seq")
    @NotNull(message = "Client ID must not be null")
    private Long clientId;

    private long creationDate;
}
