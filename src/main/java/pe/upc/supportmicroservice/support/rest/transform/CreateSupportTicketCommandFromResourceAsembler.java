package pe.upc.supportmicroservice.support.rest.transform;


import pe.upc.supportmicroservice.support.domain.model.commands.CreateSupportTicketCommand;
import pe.upc.supportmicroservice.support.rest.resources.CreateSupportTicketResource;

public class CreateSupportTicketCommandFromResourceAsembler {

    public static CreateSupportTicketCommand toCommandFromResource(CreateSupportTicketResource resource){
        return new CreateSupportTicketCommand(resource.title(), resource.type(), resource.description());
    }
}
