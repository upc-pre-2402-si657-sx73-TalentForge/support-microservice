package pe.upc.supportmicroservice.support.rest.resources;


import java.time.LocalDate;

public record SupportTicketResource(Long id, String title, String type, String description, LocalDate creationDate){
}
