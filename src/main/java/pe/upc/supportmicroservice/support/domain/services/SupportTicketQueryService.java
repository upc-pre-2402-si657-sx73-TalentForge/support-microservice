package pe.upc.supportmicroservice.support.domain.services;


import pe.upc.supportmicroservice.support.domain.model.aggregates.SupportTicket;
import pe.upc.supportmicroservice.support.domain.model.query.GetAllSupportTicketQuery;
import pe.upc.supportmicroservice.support.domain.model.query.GetSupportTicketByIdQuery;

import java.util.List;
import java.util.Optional;

public interface SupportTicketQueryService {
    Optional<SupportTicket> handle(GetSupportTicketByIdQuery query);
    List<SupportTicket> handle(GetAllSupportTicketQuery query);
}
