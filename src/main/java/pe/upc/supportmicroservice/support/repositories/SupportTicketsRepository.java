package pe.upc.supportmicroservice.support.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.supportmicroservice.support.domain.model.aggregates.SupportTicket;

@Repository
public interface SupportTicketsRepository extends JpaRepository<SupportTicket, Long> {

}
