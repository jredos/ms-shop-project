package com.jrod.store.shopping.repository;

import com.jrod.store.shopping.repository.entity.InvoiceItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItems, Long> {
}
