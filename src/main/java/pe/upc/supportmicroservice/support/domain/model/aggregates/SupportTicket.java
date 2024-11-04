package pe.upc.supportmicroservice.support.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.upc.supportmicroservice.support.domain.model.commands.CreateSupportTicketCommand;

import java.time.LocalDate;

@Getter
@Entity
public class SupportTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String Type;

    @Column(nullable = false)
    private String description;


    @Column(nullable = false)
    private LocalDate creationDate;

    public SupportTicket(CreateSupportTicketCommand createSupportTicketCommand) {
        this.title = createSupportTicketCommand.title();
        this.Type = createSupportTicketCommand.type();
        this.description = createSupportTicketCommand.description();
        this.creationDate = LocalDate.now();
    }
    public SupportTicket() {}
}
