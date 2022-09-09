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
    @NotNull(message = "Client ID cannot be null")
    private Long clientId;

    private long creationDate;
}
