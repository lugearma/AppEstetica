class AppMascotas{

	public static void main(String []args){

		//Variables locales
		int opcion, dato, max, pos, maxTels, maxCalifs;

		//Creamos variable de tipo ArregloClientes
		ArregloClientes miArreglo;

		//Crear el objeto de manera individual
		Cliente alu;
		max = Teclado.entero("Cuantos clienes quieres: ");

		//Aqui se crea el objeto, y le pasamos el tamaño del arreglo
		miArreglo = new ArregloClientes(max);	
		maxTels = Teclado.entero("Cantidad telefonos por cliente: ");
		maxCalifs = Teclado.entero("Cantidad de calificaciones por cliente: ");
		
		do{
			System.out.println("\t---------Menu Principal---------");
			opcion = Menu.desplegarMenu("1)Insertar cliente\n2)Actualizar datos del cliente\n3)Borrar cliente\n4)Listar a todos los cliente\n5)Listar un cliente\n6)Salir\nOpcion:\n", 6);
			switch(opcion){

				//Insertar
				case 1:
					if(miArreglo.validaEspacio()){
						//Aqui se crea el objeto alu, y se pasa al constructor los argumentos
						alu = new Cliente( maxCalifs, maxTels );
						miArreglo.insertar(alu);
					}
					else
						System.out.println("Error, no hay espacio en el arreglo :(");
				break;

				//Actualizar los dato del alumno ingresando nuero de cuenta
				case 2:
					dato = Teclado.entero("Ingresa el No. de cliente: ");
					pos = miArreglo.buscarDato(dato);
					if(pos >= 0)
						miArreglo.actualizar(pos);
					else
						System.out.println("No existe el cliente :(");
				break;
				
				//Borra alumno segun nuemro de cuenta
				case 3:
					dato = Teclado.entero("Numero de cliente: ");
					pos = miArreglo.buscarDato(dato);
					if (pos != -1)
						miArreglo.borrar(pos);
					else
						System.out.println("No existe el cliente");
				break;

				//Listar todos los alumnos
				case 4:
					miArreglo.listar();
				break;

				//Listar un solo alumno pide numero de cuenta
				case 5:
					dato = Teclado.entero("Ingresa el No de cliente a buscar: ");
					pos = miArreglo.buscarDato(dato);
					if(pos != -1)
						miArreglo.listar(pos);
					else
						System.out.println("No existe el cliente :(");
				break;

				default:
					System.out.println("Opcion incorrecta");
				break;
			}
		}while(opcion != 6);
	}
}