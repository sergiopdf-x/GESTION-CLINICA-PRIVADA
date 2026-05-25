# GESTION-CLINICA-PRIVADA
Sistema desarrollado en Java para la gestión de empleados de una clínica privada utilizando Programación Orientada a Objetos (POO).

## Objetivo
Administrar empleados de una clínica permitiendo:

- Registrar médicos
- Registrar administrativos
- Mostrar empleados
- Buscar empleados por cédula
- Actualizar información
- Eliminar registros
- Calcular pagos
- Mostrar estadísticas

---

## Estructura del proyecto

src/

modelo/

- Empleado.java
- Medico.java
- Administrativo.java

servicio/

- EmpleadoServicio.java

util/

- Validador.java

app/

- Main.java

---

## Conceptos POO implementados
### Herencia

Las clases hijas:
- Medico
- Administrativo
heredan de la clase padre:
- Empleado
Esto permite reutilizar atributos y métodos comunes.
Ejemplo:
```java
public class Medico extends Empleado
```

### Encapsulamiento
- Los atributos fueron declarados privados y se acceden mediante getters y setters
Ejemplo:
private String nombre;

public String getNombre(){
    return nombre;
}

### Polimorfismo
- Se utiliza el método abstracto:
  public abstract double calcularPago();
### Abstraccion
- La clase Empleado
Fue creada como abstracta para representar características generales de cualquier empleado.
### Excepciones
Se utilizó try-catch
Para controlar errores de entrada de datos
Ejemplo
catch(NumberFormatException e)
### CRUD implementado 
1. Create
- Registrar empleados
2. Read
- Mostrar empleados
3. Buscar por cédula
4. Update
- Actualizar información
5. Delete
- Eliminar empleados
### Estadisticas implementadas 
1. Total médicos
2. Total administrativos
3. Pago total médicos
4. Pago total administrativos
5. Empleado con mayor ingreso
