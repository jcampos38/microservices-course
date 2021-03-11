package jcampos.training.microservices.shoppingservice.repository;

import jcampos.training.microservices.shoppingservice.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
