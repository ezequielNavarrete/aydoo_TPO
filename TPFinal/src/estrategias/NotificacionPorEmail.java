package estrategias;

import moduloNotificaciones.Notificacion;
import estrategias.EstrategiaDeNotificacion;

public class NotificacionPorEmail implements EstrategiaDeNotificacion {

	public void enviar(Notificacion notificacion) {
		System.out.println("Enviando Email a " + notificacion.getEmailDestinatario() + "  "+ notificacion.getMensaje() );
	}
}
