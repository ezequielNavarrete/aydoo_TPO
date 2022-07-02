package estrategias;

import moduloNotificaciones.Notificacion;
import estrategias.EstrategiaDeNotificacion;

public class NotificacionPorSMS implements EstrategiaDeNotificacion {

	public void enviar(Notificacion notificacion) {
		System.out.println("Enviando SMS a " + notificacion.getTelefonoDestinatario() + "  "+ notificacion.getMensaje() );
	}
}
