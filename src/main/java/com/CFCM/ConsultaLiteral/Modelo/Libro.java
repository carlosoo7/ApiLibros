package com.CFCM.ConsultaLiteral.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "libros")
@Getter
@Setter
@NoArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String titulo;
    @ElementCollection(targetClass = Idioma.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "idioma")
    private List<Idioma> idiomas = new ArrayList<>();
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;


    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.resultados().get(0).titulo();
        List<Autor> conversion = new ArrayList<>();
        for (DatosAutor datosAutor : datosLibro.resultados().get(0).autores()) {
            Autor autor = new Autor(datosAutor.nombre(), datosAutor.añoNacimiento(), datosAutor.añoFallecimiento());
            autor.setLibro(this);
            conversion.add(autor);
        }
        this.autores = conversion;
        List<Idioma> idiomasList = new ArrayList<>();
        for (String idiomaStr : datosLibro.resultados().get(0).idioma()) {
            Idioma idioma = Idioma.fromString(idiomaStr.split(",")[0].trim());  // Puedes ajustar esto si es necesario
            idiomasList.add(idioma);
        }
        this.idiomas = idiomasList;

    }

    @Override
    public String toString() {
        return "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", idiomas=" + idiomas +
                ", autores=" + autores;
    }
}


