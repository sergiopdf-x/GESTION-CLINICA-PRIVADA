package servicio;
import modelo.*;
import java.util.ArrayList;
public class EmpleadoServicio {
    private ArrayList<Empleado> lista;
    public EmpleadoServicio(){
        lista = new ArrayList<>();
    }

    public boolean agregar(Empleado e){
        for(Empleado em:lista) {
            if (em.getCedula().equals(e.getCedula())) {
                return false;
            }
        }
        lista.add(e);
        return true;
    }

    public void mostrar(){
        if(lista.isEmpty()){
            System.out.println("No existen registros");
            return;
        }
        for (Empleado e:lista){
            System.out.println(e.mostrarInformacion());
        }
    }

    public Empleado buscar(String cedula){
        for (Empleado e:lista){
            if(e.getCedula().equals(cedula)){
                return e;
            }
        }
        return null;
    }

    public boolean eliminar(String cedula){
        Empleado e = buscar(cedula);
        if (e!=null){
            lista.remove(e);
            return true;
        }
        return false;
    }

    public int totalMedicos() {
        int total = 0;
        for (Empleado e:lista){
            if (e instanceof Medico){
                total ++;
            }
        }
        return total;
    }

    public int totalAdministrativos(){
        int total = 0;
        for (Empleado e:lista){
            if (e instanceof Administrativo){
                total ++;
            }
        }
        return total;
    }

    public double pagoMedicos() {
        double total = 0;
        for (Empleado e : lista){
            if (e instanceof Medico){
                total += e.calcularPago();
            }
        }
        return total;
    }

    public double pagoAdministrativo(){
        double total = 0;
        for (Empleado e : lista){
            if (e instanceof Administrativo){
                total += e.calcularPago();
            }
        }
        return total;
    }

    public Empleado mayorIngreso(){
        if (lista.isEmpty()){
            return null;
        }

        Empleado mayor = lista.get(0);
        for (Empleado e : lista){
            if(e.calcularPago() > mayor.calcularPago()){
                mayor = e;
            }
        }
        return mayor;
    }
}