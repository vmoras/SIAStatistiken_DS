package data;

public class Degree {
    // TODO: FINISH
    private final String nivelId = "pt1:r1:0:soc1::content";
    private final String faculadldId = "pt1:r1:0:soc2::content";
    private final String carreraId = "pt1:r1:0:soc3::content";

    private String nivelNombre;
    private String facultadNombre;
    private String carreraNombre;
    private int numCursos;

    public String getFaculadldId() {
        return faculadldId;
    }

    public String getCarreraId() {
        return carreraId;
    }

    public String getNivelId() {
        return nivelId;
    }

    public String getNivelNombre() {
        return nivelNombre;
    }

    public String getFacultadNombre() {
        return facultadNombre;
    }

    public String getCarreraNombre() {
        return carreraNombre;
    }

    public int getNumCursos() {
        return numCursos;
    }

    public void setNivelNombre(String nivelNombre) {
        this.nivelNombre = nivelNombre;
    }

    public void setCarreraNombre(String carreraNombre) {
        this.carreraNombre = carreraNombre;
    }

    public void setFacultadNombre(String facultadNombre) {
        this.facultadNombre = facultadNombre;
    }

    public void setNumCursos(int numCursos) {
        this.numCursos = numCursos;
    }
}
