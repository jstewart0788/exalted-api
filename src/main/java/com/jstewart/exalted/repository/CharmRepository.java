package com.jstewart.exalted.repository;

import com.jstewart.exalted.model.Charm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharmRepository extends JpaRepository<Charm, Long> {
}