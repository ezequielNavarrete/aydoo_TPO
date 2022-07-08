package modelado;
import modelado.NotificacionPorDefecto;

public class Persona {
	
	private boolean esInquilino;
	private NotificacionPorDefecto notificacion;
	private String nombre;
	private int DNI;
	
	public String getNombre() {
		return nombre;
	}
	public Persona(NotificacionPorDefecto notificacion, int dNI) {
		this.notificacion = notificacion;
		DNI = dNI;
	}

	public NotificacionPorDefecto getNotificacion() {
		return notificacion;
	}
	public void setNotificacion(NotificacionPorDefecto notificacion) {
		this.notificacion = notificacion;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public int getDNI() {
		return DNI;
	}
	public boolean EsInquilino() {
		return esInquilino;
	}
	public void setEsInquilino(boolean esInquilino) {
		this.esInquilino = esInquilino;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
