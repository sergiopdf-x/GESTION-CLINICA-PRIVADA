package app;
import java.util.Scanner;
import modelo.*;
import servicio.*;
import util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        EmpleadoServicio servicio= new EmpleadoServicio();
        int opcion=0;
        do{
            try{
                System.out.println("\n===== CLINICA SALUD TOTAL =====");
                System.out.println("1. Registrar medico");
                System.out.println("2. Registrar administrativo");
                System.out.println("3. Mostrar empleados");
                System.out.println("4. Buscar cedula");
                System.out.println("5. Reemplazar informacion");
                System.out.println("6. Eliminar");
                System.out.println("7. Calcular pagos");
                System.out.println("8. Estadisticas");
                System.out.println("0. Salir");

                System.out.print("Opcion: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch(opcion){
                    case 1:
                        registrarMedico(sc,servicio);
                        break;
                    case 2:
                        registrarAdministrativo(sc, servicio);
                        break;
                    case 3:
                        servicio.mostrar();
                        break;
                    case 4:
                        buscar(sc,servicio);
                        break;
                    case 5:
                        actualizar(sc, servicio);
                        break;
                    case 6:
                        eliminar(sc, servicio);
                        break;
                    case 7:
                        pagos(servicio);
                        break;
                    case 8:
                        estadisticas(servicio);
                        break;
                    case 0:
                        System.out.println("PROGRAMA TERMINADO");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            }catch(NumberFormatException e){
                System.out.println("Dato invalido");
            }
        } while(opcion!=9);
    }

    static void registrarMedico(Scanner sc,EmpleadoServicio servicio){
        try{
            System.out.print("Cedula: ");
            String cedula = sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            System.out.print("Telefono: ");
            String telefono = sc.nextLine();

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();

            System.out.print("Pacientes: ");
            int pacientes = Integer.parseInt(sc.nextLine());

            System.out.print("Valor consulta: $");
            double valor = Double.parseDouble(sc.nextLine());
            Medico m= new Medico(cedula,nombre,edad,telefono,correo,especialidad,pacientes,valor);
            if(servicio.agregar(m))
                System.out.println("Medico guardado correctamente");
            else
                System.out.println("Cedula repetida");

        }catch(Exception e){
            System.out.println("Error");
        }
    }

    static void registrarAdministrativo(Scanner sc, EmpleadoServicio servicio){
        try{
            System.out.print("Cedula: ");
            String cedula = sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            System.out.print("Telefono: ");
            String telefono = sc.nextLine();

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            System.out.print("Departamento: ");
            String departamento = sc.nextLine();

            System.out.print("Horas: ");
            int horas = Integer.parseInt(sc.nextLine());

            System.out.println("Valor por hora: $");
            double valorHora = Double.parseDouble(sc.nextLine());
            Administrativo a = new Administrativo(cedula,nombre,edad,telefono,correo,departamento,horas,valorHora);
            servicio.agregar(a);
        }catch(Exception e){
            System.out.println("Error");
        }
    }

    static void buscar(Scanner sc,EmpleadoServicio servicio){
        System.out.println("Cedula del empleado a buscar: ");
        String cedula = sc.nextLine();
        Empleado e = servicio.buscar(cedula);
        if(e==null)
            System.out.println("No encontrado");
        else
            System.out.println(e.mostrarInformacion());
    }

    static void actualizar(Scanner sc,EmpleadoServicio servicio){
        System.out.println("Cedula del empleado a actualizar: ");
        String cedula = sc.nextLine();
        Empleado e = servicio.buscar(cedula);
        if(e!=null){
            e.setNombre(sc.nextLine());
        }
    }

    static void eliminar(Scanner sc,EmpleadoServicio servicio){
        System.out.println("Cedula del empleado a eliminar: ");
        String cedula = sc.nextLine();
        servicio.eliminar(cedula);
    }

    static void pagos(EmpleadoServicio servicio){
        servicio.mostrar();
    }

    static void estadisticas(EmpleadoServicio servicio){
        System.out.println("Total medicos: " + servicio.totalMedicos());
        System.out.println("Total administrativos: " + servicio.totalAdministrativos());
        System.out.println("Total empleados: " + (servicio.totalMedicos() + servicio.totalAdministrativos()));
        System.out.println("Pago medicos: " + servicio.pagoMedicos());
        System.out.println("Pago administrativos: " + servicio.pagoAdministrativo());
        Empleado mayor= servicio.mayorIngreso();
        if(mayor!=null){
            System.out.println("Mayor ingreso");
            System.out.println(mayor.mostrarInformacion());
        }
    }
}