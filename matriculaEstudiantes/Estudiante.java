package matriculaEstudiantes;

class Estudiante {

    private String nombre;
    private String apellido;
    private String documento;
    private String direccion;
    private String telefono;
    private String carrera;
    private int semestre;
    private boolean esEnLinea;
    private int materiasPerdidas;
    private int creditosSemestre;

    public Estudiante(String nombre, String apellido, String documento, String direccion, String telefono, String carrera, int semestre, boolean esEnLinea, int materiasPerdidas, int creditosSemestre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.carrera = carrera;
        this.semestre = semestre;
        this.esEnLinea = esEnLinea;
        this.materiasPerdidas = materiasPerdidas;
        this.creditosSemestre = creditosSemestre;
    }

    public double calcularMatricula() {
        double precioBase = 1500;
        double costoPorCredito;

        // Determinar el costo por crédito según el semestre
        if (semestre <= 3) {
            costoPorCredito = 20;
        } else if (semestre <= 6) {
            costoPorCredito = 25;
        } else {
            costoPorCredito = 30;
        }

        if (esEnLinea) {
            // Ajuste en línea si el semestre es mayor o igual a 5
            if (semestre >= 5) {
                return precioBase * 1.05; // 5% de aumento
            } else {
                return precioBase;
            }
        } else {
            // Cálculo para estudiantes presenciales
            double costoMateriaPerdida = costoPorCredito;
            return precioBase + materiasPerdidas * costoMateriaPerdida + creditosSemestre * costoPorCredito;
        }
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean isEsEnLinea() {
        return esEnLinea;
    }

    public void setEsEnLinea(boolean esEnLinea) {
        this.esEnLinea = esEnLinea;
    }

    public int getMateriasPerdidas() {
        return materiasPerdidas;
    }

    public void setMateriasPerdidas(int materiasPerdidas) {
        this.materiasPerdidas = materiasPerdidas;
    }

    public int getCreditosSemestre() {
        return creditosSemestre;
    }

    public void setCreditosSemestre(int creditosSemestre) {
        this.creditosSemestre = creditosSemestre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                ", esEnLinea=" + esEnLinea +
                ", materiasPerdidas=" + materiasPerdidas +
                ", creditosSemestre=" + creditosSemestre +
                '}';
    }
}
