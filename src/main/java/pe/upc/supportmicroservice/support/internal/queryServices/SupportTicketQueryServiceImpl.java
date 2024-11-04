package pe.upc.supportmicroservice.support.internal.queryServices;

import org.springframework.stereotype.Service;
import pe.upc.supportmicroservice.support.domain.model.aggregates.SupportTicket;
import pe.upc.supportmicroservice.support.domain.model.query.GetAllSupportTicketQuery;
import pe.upc.supportmicroservice.support.domain.model.query.GetSupportTicketByIdQuery;
import pe.upc.supportmicroservice.support.domain.services.SupportTicketQueryService;
import pe.upc.supportmicroservice.support.repositories.SupportTicketsRepository;

import java.util.List;
import java.util.Optional;


@Service
public class SupportTicketQueryServiceImpl implements SupportTicketQueryService {
    private final SupportTicketsRepository supportTicketsRepository;

    public SupportTicketQueryServiceImpl(SupportTicketsRepository supportTicketsRepository) {
        this.supportTicketsRepository = supportTicketsRepository;
    }

    @Override
    public Optional<SupportTicket> handle(GetSupportTicketByIdQuery query) {
        return this.supportTicketsRepository.findById(query.id());
    }

    @Override
    public List<SupportTicket> handle(GetAllSupportTicketQuery query) {
        return this.supportTicketsRepository.findAll();
    }
}
