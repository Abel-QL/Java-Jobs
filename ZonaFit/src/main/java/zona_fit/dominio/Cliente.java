package zona_fit.dominio;

import java.util.Objects;

public class Cliente {
    private int id;
    private String name;
    private String lastName;
    private int membresia;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String name, String lastName, int membresia) {
        this.name = name;
        this.lastName = lastName;
        this.membresia = membresia;
    }

    public Cliente(int id, String name, String lastName, int membresia) {
        this(name, lastName, membresia);
        this.id = id;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMembresia() {
        return membresia;
    }

    public void setMembresia(int membresia) {
        this.membresia = membresia;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", membresia=" + membresia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && membresia == cliente.membresia && Objects.equals(name, cliente.name) && Objects.equals(lastName, cliente.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, membresia);
    }
}
