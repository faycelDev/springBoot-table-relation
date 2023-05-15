package com.fays.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {



}
