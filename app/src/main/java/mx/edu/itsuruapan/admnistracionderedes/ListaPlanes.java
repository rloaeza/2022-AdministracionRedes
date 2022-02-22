package mx.edu.itsuruapan.admnistracionderedes;

public class ListaPlanes {
    public String nombre_plan;
    public String descripcion_plan;
    public String idUsuario;
    public ListaPlanes(String nombre_plan, String descripcion_plan, String idUsuario) {
        this.nombre_plan = nombre_plan;
        this.descripcion_plan = descripcion_plan;
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre_plan() {
        return nombre_plan;
    }

    public void setNombre_plan(String nombre_plan) {
        this.nombre_plan = nombre_plan;
    }

    public String getDescripcion_plan() {
        return descripcion_plan;
    }

    public void setDescripcion_plan(String descripcion_plan) {
        this.descripcion_plan = descripcion_plan;
    }
}
