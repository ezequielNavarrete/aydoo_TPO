package moduloNotificaciones.estrategias;

import moduloNotificaciones.Notificacion;


public class NotificacionPorEmail implements EstrategiaDeNotificacion {

	@Override
	public void enviar(Notificacion notificacion) {
		System.out.println("El usuario " + notificacion.getNombre() + " con DNI: " + notificacion.getDni() + " fue notificado mediante email.");

	}

}
