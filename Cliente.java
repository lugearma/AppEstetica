class Cliente{

	//Atrubutos del cliente
	private int edad;	
	private String nombre, sexo;
	private Direccion dir;
	private ArregloEntero tels;
	private Mascotas masco;

	public Cliente(int maxMascotas, int maxTels){
		leeNombreCliente();
		leeSexoCliente();
		leeEdadCliente();
		dir = new Direccion();
		masco = new Mascotas();
		tels = new ArregloEntero(maxTels);
	}

	//*********************Objetos de las otras clases***********

	//Guarda el nombre del alumno
	private void leeNombreCliente(){
		nombre = Teclado.cadena("Ingresa el nombre del cliente: ");
	}

	private void leeSexoCliente(){
		nombre = Teclado.cadena("Ingresa el sexo del cliente: ");
	}
	
	private void leeEdadCliente(){
		edad = Teclado.entero("Ingresa la edad del cliente: ");
	}

	//Captura telefonos validando que exista espacio en ArregloEnteros
	private void capturaTels(){

		int dato, opc;

		do{
			//Valida espacio
			if (tels.validaEspacio()){
				dato = Teclado.entero("Ingresa el telefono: ");
				//Guarda telefono
				tels.insertar(dato);
			}
			else{
				System.out.println("No hay espacio");
				opc = 2;
			}

			opc = Teclado.entero("Quieres ingresar otro telefono: \n1) SI \n2) NO\n");
		}while(opc != 2);
	}

	//Lista los atributos locales, los de otras clases lo listan con sus porpio metodos
	public void listar(){
		System.out.println("\t\n*******Datos de alumno*******");
		System.out.println("\nNombre del cliente: "+ nombre);
		//Lista con los metodos propios
		System.out.println("\nTelefonos: ");
		tels.listar();
		System.out.println("\nDireccion: ");
		dir.listar();
		System.out.println("\n");
	}

	//Actualiza los datos del alumno
	public void actualizar(){
		int opc, sal;
		do{
	    opc =  Menu.desplegarMenu("\n1)Actualizar nombre\n2)Actualizar domicilio\n3)Actualizar telefono\n4)Salir\n", 4);
			switch(opc){
				case 1:
					leeNombreCliente();
				break;

				case 2:
					dir.actualizarDomicilio();
				break;

				case 3:
					actulizarTels();
				break;

				default:
					System.out.println("Opcion invalida :(");
				break;
			}
		}while(opc != 5);
	}

	//Metodo privado que actuliza los tels, usado en el metodo actualizar()
	private void actulizarTels(){
		int opc, dato, pos;
	    opc =  Menu.desplegarMenu("\n1)Insertar nuevo telefono\n2)Actualizar telefono\n3)Borrar telefono\n4)Salir", 4);
		do{
			switch(opc){
				//Insertar nuevo telefono, validando espacio
				case 1:
					capturaTels();
				break;

				//Actualiza telefono existente, usa metodo de ArregloEntero
				case 2:
					dato = Teclado.entero("Dame el telefono que deseas actualizar: ");
					pos = tels.buscarDato(dato);
					if(pos != -1)
						tels.actualizar(pos);
					else
						System.out.println("El telefono no existe :(");
				break;

				//Borrar telefono
				case 3:
					dato = Teclado.entero("Que telefono quieres borrar: ");
					pos = tels.buscarDato(dato); 
					if(pos!=-1)
						tels.borrar(dato);
					else
						System.out.println("El telefono no existe :(");
				break;

				default:
					System.out.println("Opcion incorrecta :(");
				break;
			}
		}while(opc != 4);
	}

	public void actualizaDatosCliente(){
		int opc;
		do{
			opc = Menu.desplegarMenu("1)Actualizar Nombre\n2)Actualizar Sexo\n3)Actualizar Edad\n 5)Salir", 5);
			switch(opc){
				case 1:
					leeNombreCliente();
				break;
				case 2:
					leeSexoCliente();
				break;
				case 3:
					leeEdadCliente();
				break;
				default:
					System.out.println("Opcion incorrecta");
				break;
			}
		}while(opc != 5);
	}
}