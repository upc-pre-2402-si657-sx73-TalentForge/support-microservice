package pe.upc.supportmicroservice.support.domain.model.commands;


public record CreateSupportTicketCommand(String title, String type, String description){
}
