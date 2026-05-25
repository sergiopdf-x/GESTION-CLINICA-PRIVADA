package modelo;
public class Medico extends Empleado{
    private String especialidad;
    private int pacientes;
    private double valorConsulta;

    public Medico(String cedula, String nombre, int edad, String telefono, String correo, String especialidad, int pacientes, double valorConsulta) {
        super(cedula, nombre, edad, telefono, correo);
        this.especialidad = especialidad;
        this.pacientes = pacientes;
        this.valorConsulta = valorConsulta;
    }

    public int getPacientes(){
        return pacientes;
    }

    @Override
    public double calcularPago(){
        return pacientes * valorConsulta;
    }

    @Override
    public String mostrarInformacion(){
        return super.mostrarInformacion() + "\nCargo: MEDICO" + "\nEspecialidad: "
                + especialidad + "\nPacientes: " + pacientes + "\nValor consulta: "
                +valorConsulta + "\nPago: $" + calcularPago();
    }
}
