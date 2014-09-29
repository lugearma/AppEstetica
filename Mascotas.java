class Mascotas{

	private String nombre, raza, tamanoDeRaza, sexo;
	private int edad;

	//Constructor de Mascotas, toma todos los metodos privados
	public Mascotas(){
		leeNombre();
		leeRaza();
		leeSexo();
		leeEdad();
		leeTamano();
	}

	//Pide nombre
	private void leeNombre(){
		nombre = Teclado.cadena("Nombre de la mascota :");
	}

	//Pide raza
	private void leeRaza(){
		raza = Teclado.cadena("Raza del perro: ");
	}
	
	//Pide sexo
	private void leeSexo(){
		sexo = Teclado.cadena("Sexo: ");
	}

	//Pide la edad
	private void leeEdad(){
		edad = Teclado.entero("Edad de la mascota: ");
	}

	//Necesito que me regresa la raza para la estadistica
	public int leeTamano(){
		int opc;
		opc = Menu.desplegarMenu("Tamaño de la raza\n1) Chica\n2)Mediana\n3)Grande", 3);
		return opc;
	}

	//Lista datos de mascotas
	public void listarDatosMascota(){
		System.out.println("Nombre: " + nombre);
		System.out.println("Raza: " + raza);
		System.out.println("Sexo: " + sexo);
		System.out.println("Edad: " + edad);
	}

	//Actualiza datos de masxotas
	public void actualizarMascota(){
		int opc;
		do{
			opc = Menu.desplegarMenu("1)Actualizar Nombre\n2)Actualizar Raza\n3)Actualizar Sexo\n4) Actualizar Edad\n 5)Salir", 5);
			switch(opc){
				case 1:
					leeNombre();
				break;
				case 2:
					leeRaza();
				break;
				case 3:
					leeSexo();
				break;
				case 4:
					leeEdad();
				break;
				default:
					System.out.println("Opcion icorrecta");
				break;
			}
		}while(opc != 5);
	}
}