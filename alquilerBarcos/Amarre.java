package alquilerBarcos;

import java.util.ArrayList;
import java.util.List;

public class Amarre {
    private String identificador;
    private String ubicacion;
    private List<Alquiler> alquileres;

    public Amarre(String identificador, String ubicacion) {
        this.identificador = identificador;
        this.ubicacion = ubicacion;
        this.alquileres = new ArrayList<>();
    }

    public void agregarAlquiler(Alquiler alquiler) {
        alquileres.add(alquiler);
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    @Override
    public String toString() {
        return "Amarre{" +
                "identificador='" + identificador + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", alquileres=" + alquileres +
                '}';
    }
}
