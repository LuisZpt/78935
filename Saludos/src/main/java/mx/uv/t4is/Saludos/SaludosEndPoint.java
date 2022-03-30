package mx.uv.t4is.Saludos;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorrarSaludoRequest;
import https.t4is_uv_mx.saludos.BorrarSaludoResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoRequest;
import https.t4is_uv_mx.saludos.ModificarSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse.Saludos;

public class SaludosEndPoint {
	ArrayList<Saludos> lista= new ArrayList<>();
	private int i= 1;

	@PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")
	@ResponseBody
	public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
		SaludarResponse respuesta = new SaludarResponse();
		respuesta.setRespuesta("Hola "+peticion.getNombre());
		Saludos e= new Saludos();
		e.setNombre("Hola "+peticion.getNombre());
		e.setId(i++);
		// agrega a la lista
		lista.add(e);
		return respuesta;
	}

	@PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "https://t4is.uv.mx/saludos")
	@ResponseBody
	public BuscarSaludosResponse buscarSaludos(){
		BuscarSaludosResponse respuesta= new BuscarSaludosResponse();
		// recorrer la lista
		for(Saludos o :lista){
			respuesta.getSaludos().add(o);
		}
		return respuesta;
	}

	@PayloadRoot(localPart = "ModificarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
	@ResponsePayload
	public ModificarSaludoResponse modificarSaludos(@RequestPayload ModificarSaludoRequest peticion){
		ModificarSaludoResponse respuesta= new ModificarSaludoResponse();
		//Modificar de la lista
		Saludos element= new Saludos();
		element.setId(peticion.getId());
		element.setNombre(peticion.getNombre());
		lista.set(peticion.getId()-1, element);
		respuesta.setRespuesta(true);
		return respuesta;
	}

	@PayloadRoot(localPart = "BorrarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
	@ResponsePayload
	public BorrarSaludoResponse borrarSaludo(@RequestPayload BorrarSaludoRequest peticion){
		BorrarSaludoResponse respuesta= new BorrarSaludoResponse();
		//eliminar de la lista
		for(Saludos o: lista){
			if(o.getId() == peticion.getId()){
				lista.remove(o);
				break;
			}
		}

		respuesta.setRespuesta(true);
		return respuesta;
	}
}