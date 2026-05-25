package modelo;
public class Administrativo extends Empleado{
    private String departamento;
    private int horas;
    private double valorHora;

    public Administrativo(String cedula, String nombre, int edad, String telefono, String correo, String departamento, int horas, double valorHora) {
        super(cedula, nombre, edad, telefono, correo);
        this.departamento = departamento;
        this.horas = horas;
        this.valorHora = valorHora;
    }

    public int getHoras(){
        return horas;
    }

    @Override
    public double calcularPago(){
        return horas * valorHora;
    }

    @Override
    public String mostrarInformacion(){
        return super.mostrarInformacion() + "\nCargo: ADMINISTRATIVO" + "\nDepartamento: " +
                departamento + "\nHoras: " + horas + "Valor hora: $" + valorHora +
                "\nPago: $" + calcularPago();
    }
}
