package pe.upc.supportmicroservice.support.internal.commandServices;

import org.springframework.stereotype.Service;
import pe.upc.supportmicroservice.support.domain.model.aggregates.SupportTicket;
import pe.upc.supportmicroservice.support.domain.model.commands.CreateSupportTicketCommand;
import pe.upc.supportmicroservice.support.domain.services.SupportTicketCommandService;
import pe.upc.supportmicroservice.support.repositories.SupportTicketsRepository;

import java.util.Optional;

@Service
public class SupportTicketCommandServiceImpl implements SupportTicketCommandService {

    private final SupportTicketsRepository supportTicketsRepository;

    public SupportTicketCommandServiceImpl(SupportTicketsRepository supportTicketsRepository) {
        this.supportTicketsRepository = supportTicketsRepository;
    }

    @Override
    public Optional<SupportTicket> handle(CreateSupportTicketCommand command) {
        var supportTicket = new SupportTicket(command);
        this.supportTicketsRepository.save(supportTicket);
        return Optional.of(supportTicket);
    }
}
