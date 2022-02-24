using System;
using WSDL.mensajes;

namespace WSDL.operaciones
{
	public class Operaciones : Mensajes
	{
		public string Saludar(string nombre)
		{
			string msj= "Hola "+nombre+", te saluda Luis :3";
			return msj;
		}
		public string Mostrar(int id){
			return "x";
		}
	}
}
