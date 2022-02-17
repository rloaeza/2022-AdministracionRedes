package mx.edu.itsuruapan.admnistracionderedes;

public class ListaPlanes {
    public String nombre_plan;
    public String descripcion_plan;

    public ListaPlanes(String nombre_plan, String descripcion_plan) {
        this.nombre_plan = nombre_plan;
        this.descripcion_plan = descripcion_plan;
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
