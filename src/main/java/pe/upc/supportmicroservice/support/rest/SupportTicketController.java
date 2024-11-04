package pe.upc.supportmicroservice.support.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.supportmicroservice.support.domain.model.query.GetAllSupportTicketQuery;
import pe.upc.supportmicroservice.support.domain.model.query.GetSupportTicketByIdQuery;
import pe.upc.supportmicroservice.support.domain.services.SupportTicketCommandService;
import pe.upc.supportmicroservice.support.domain.services.SupportTicketQueryService;
import pe.upc.supportmicroservice.support.rest.resources.CreateSupportTicketResource;
import pe.upc.supportmicroservice.support.rest.resources.SupportTicketResource;
import pe.upc.supportmicroservice.support.rest.transform.CreateSupportTicketCommandFromResourceAsembler;
import pe.upc.supportmicroservice.support.rest.transform.SupportTicketResourceFromEntityAssembler;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="v1/api/support-tickets")
@Tag(name = "Support Tickets", description = "Support Tickets management endpoint")
public class SupportTicketController {

    private final SupportTicketCommandService supportTicketCommandService;
    private final SupportTicketQueryService supportTicketQueryService;

    public SupportTicketController(SupportTicketCommandService supportTicketCommandService, SupportTicketQueryService supportTicketQueryService) {
        this.supportTicketCommandService = supportTicketCommandService;
        this.supportTicketQueryService = supportTicketQueryService;
    }

    @Operation(summary = "Create Support Ticket")
    @PostMapping
    public ResponseEntity<SupportTicketResource>createSupportTicket(@RequestBody CreateSupportTicketResource resource){
        var createSupportTicketCommand = CreateSupportTicketCommandFromResourceAsembler.toCommandFromResource(resource);
        var supportTicket = this.supportTicketCommandService.handle(createSupportTicketCommand);
        if(supportTicket.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var supportTicketResource = SupportTicketResourceFromEntityAssembler.toResourceFromEntity(supportTicket.get());
        return new ResponseEntity<>(supportTicketResource, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all support tickets")
    @GetMapping
    public ResponseEntity<List<SupportTicketResource>> getAllSupportTickets(){
        var getAllSupportTicketsQuery = new GetAllSupportTicketQuery();
        var supportTickets = this.supportTicketQueryService.handle(getAllSupportTicketsQuery);
        var supportTicketsResource = supportTickets.stream()
                .map(SupportTicketResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(supportTicketsResource);
    }

    @Operation(summary = "Get support ticket by id")
    @GetMapping(value= "/{id}")
    public ResponseEntity<SupportTicketResource> getSupportTicketById(@PathVariable Long id){
        var getSupportTicketByIdQuery = new GetSupportTicketByIdQuery(id);
        var supportTicket = this.supportTicketQueryService.handle(getSupportTicketByIdQuery);
        if(supportTicket.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var supportTicketResource = SupportTicketResourceFromEntityAssembler.toResourceFromEntity(supportTicket.get());
        return ResponseEntity.ok(supportTicketResource);
    }
}
