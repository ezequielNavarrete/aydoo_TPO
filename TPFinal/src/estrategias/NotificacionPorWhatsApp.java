package estrategias;

import moduloNotificaciones.Notificacion;
import estrategias.EstrategiaDeNotificacion;

public class NotificacionPorWhatsApp implements EstrategiaDeNotificacion {

	public void enviar(Notificacion notificacion) {
		System.out.println("Enviando mensaje a " + notificacion.getTelefonoDestinatario() + "  "+ notificacion.getMensaje() );
	}
}
