package practicas.practica01;

import java.util.ArrayList;

public class Artista {
    private String nombre;
    private String ciudad;     
    private int anyo;  // año de nacimiento (si es solista) o de formación si es grupo
    private String imagenUrl;
    private final ArrayList<String> miembros; // solista → nombre completo; grupo → nombre de los componentes
    
    public Artista(String...values){
    	if (values.length !=4) throw new RuntimeException ("Formato: nombre, ciudad, año, imagenURL");
    	//5 líneas
    	//...
    }
    
    public Artista(String nombre) { //Este sería el constructor de búsqueda (ligero)
       	this.nombre = nombre;
    	this.ciudad = null;
    	this.anyo = -1;
    	this.imagenUrl = null;
    	this.miembros =  null; //Ojo con esto
    }
    
   public String getNombre() {
    	return this.nombre;
    }
    
    public int getAnyo() {
    	return this.anyo;
    }
    
    public String getCiudad() {
    	return this.ciudad;
    }
    
    public String getImagenURL() {
    	return this.imagenUrl;
    }
    
    public String getMiembrosToString() {
    	//1 única línea
    	return //...
    }
        	
    public void addMiembros(String...miembros) {
    	//Si miembros == null no hago nada
    	//1 for()
    	//... 
    }
    
    public void clear() {
    	//2 líneas
    	//...
    }
    
    @Override
    public String toString() {
    	//1 única línea
    	return //... 
    }
    
    @Override
    public boolean equals(Object otro) { 
    	if (otro == null) return false; // ¿Por qué false?
    	if (this == otro) return true; // ¿Por qué true?
    	if (!(otro instanceof Artista)) return false; //¿Para qué sirve esto?
    	//la clave es el atributo nombre
    	//1 única línea
    	return //...
    }
}