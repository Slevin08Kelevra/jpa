package com.project.persist.area.ent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "persona")
@XmlRootElement
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private Integer orden;
    private Country country;
    private Integer paisId;
    private PersonaExt personaExt;
    private String username;
    private Set<Language> languages;
    private Set<PersonTag> tags;

    private final List<PatchedFields> updatedFields = new ArrayList<PatchedFields>();

    public List<PatchedFields> updatedFields() {
        return updatedFields;
    }

    public enum PatchedFields {
        nombre, apellido, direccion, telefono
    }

    @Id
    @GeneratedValue
    //@Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nombre", length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        updatedFields.add(PatchedFields.nombre);
    }

    @Column(name = "apellido", length = 45)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        updatedFields.add(PatchedFields.apellido);
    }

    @Column(name = "direccion", length = 45)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "telefono", length = 45)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Transient
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @ManyToOne
    @JoinColumn(name = "country", insertable = false, updatable = false)
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Column(name = "country")
    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public PersonaExt getPersonaExt() {
        return personaExt;
    }

    public void setPersonaExt(PersonaExt personaExt) {
        this.personaExt = personaExt;
    }

    @Column(name = "username", length = 45)
    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "persona_lang", joinColumns = {
            @JoinColumn(name = "PERSONA_ID", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "LANGUAGE_ID", referencedColumnName = "id", nullable = false, updatable = false) })
    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(name = "persona_tag", joinColumns = {
            @JoinColumn(name = "PERSONA_ID", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "TAG_ID", referencedColumnName = "id", nullable = false, updatable = false) })
    public Set<PersonTag> getTags() {
        return tags;
    }

    public void setTags(Set<PersonTag> tags) {
        this.tags = tags;
    }

}