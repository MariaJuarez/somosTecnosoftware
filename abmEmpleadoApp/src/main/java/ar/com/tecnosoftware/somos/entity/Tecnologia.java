package ar.com.tecnosoftware.somos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class Tecnologia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTecnologia")
    private int idTecnologia;

    @Basic
    @Column(name = "DescTecnologia")
    private String descTecnologia;

    @Basic
    @Column(name = "baja")
    private boolean baja;

    @ManyToOne
    @JoinColumn(name = "IdTipoTecnologia", referencedColumnName = "IdTipoTecnologia", nullable = false)
    private TipoTecnologia tipoTecnologia;

    @Enumerated(EnumType.ORDINAL)
    private Senority senority;

}
