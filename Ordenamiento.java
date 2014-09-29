class Ordenamiento {

  private void intercambiarDatos(Cliente v[], int i, int j){
   
    Cliente aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

	public void sortSeleccion(Cliente v[], int indice){
    int im,i,j;
    for(i = 0; i < indice; i++ ){
      im = i;
      for(j = i + 1; j <= indice; j++ ){
        if(v[j].getNumeroCliente() < v[im].getNumeroCliente())
          im = j;
      }
      if(i != im)
        intercambiarDatos(v, i, im);
    }
  }
}