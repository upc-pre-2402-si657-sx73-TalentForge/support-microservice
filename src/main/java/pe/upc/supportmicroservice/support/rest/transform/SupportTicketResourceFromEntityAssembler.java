package pe.upc.supportmicroservice.support.rest.transform;


import pe.upc.supportmicroservice.support.domain.model.aggregates.SupportTicket;
import pe.upc.supportmicroservice.support.rest.resources.SupportTicketResource;

public class SupportTicketResourceFromEntityAssembler {

    public static SupportTicketResource toResourceFromEntity(SupportTicket entity) {
        return new SupportTicketResource(entity.getId(), entity.getTitle(), entity.getType(), entity.getDescription(), entity.getCreationDate());
    }
}
