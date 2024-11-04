package pe.upc.supportmicroservice.support.rest.resources;

public record CreateSupportTicketResource(String title, String type, String description, Long senderId) {
}
