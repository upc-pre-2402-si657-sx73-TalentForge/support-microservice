package pe.upc.supportmicroservice.support.domain.services;


import pe.upc.supportmicroservice.support.domain.model.aggregates.SupportTicket;
import pe.upc.supportmicroservice.support.domain.model.commands.CreateSupportTicketCommand;

import java.util.Optional;

public interface SupportTicketCommandService {
    Optional<SupportTicket> handle(CreateSupportTicketCommand command);
}
