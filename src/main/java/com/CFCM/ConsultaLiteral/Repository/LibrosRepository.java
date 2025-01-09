package com.CFCM.ConsultaLiteral.Repository;

import com.CFCM.ConsultaLiteral.Modelo.Idioma;
import com.CFCM.ConsultaLiteral.Modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIdiomasContaining(Idioma idioma);

    @Query("SELECT l FROM Libro l JOIN l.autores a WHERE a.añoNacimiento <= :año AND (a.añoFallecimiento >= :año OR a.añoFallecimiento IS NULL)")
    List<Libro> findbyaño(Integer año);
}

