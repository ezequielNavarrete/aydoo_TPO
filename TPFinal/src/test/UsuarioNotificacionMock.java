package test;

import moduloNotificaciones.estrategias.Estrategia;

public class UsuarioNotificacionMock {
	private int dni;
	private String nombre;
	private String mensaje;
	private Estrategia estrategiaElegida;
	
	public UsuarioNotificacionMock(int dni, String nombre, String mensaje, Estrategia estrategiaElegida) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.mensaje = mensaje;
		this.estrategiaElegida = estrategiaElegida;
	}


	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Estrategia getEstrategiaElegida() {
        return estrategiaElegida;
    }
	
}
