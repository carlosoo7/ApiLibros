package com.CFCM.ConsultaLiteral.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Autores")
@Getter
@Setter
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true, nullable = false)
    String nombre;
    Integer añoNacimiento;
    Integer añoFallecimiento;
    @ManyToOne()
    @JoinColumn(name = "libro_id")
    private Libro libro;


    public Autor(String nombre, Integer añoNacimiento, Integer añoFallecimiento) {
        this.nombre = nombre;
        this.añoNacimiento = añoNacimiento;
        this.añoFallecimiento = añoFallecimiento;
    }

    public String toString() {
        return "id=" + id +
                ", Nombre='" + nombre + '\'' +
                ", año de nacimiento=" + añoNacimiento +
                ", año de fallecimiento=" + añoFallecimiento;
    }
}
