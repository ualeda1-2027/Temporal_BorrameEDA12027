package practicas.practica01;

import java.util.ArrayList;
import auxiliar.Format;

public class Cancion {
	 private String titulo;
	 private int duracion;
	 private String fechaLanzamiento;
	 private boolean explicit;
	 private String genero;
	 private final ArrayList<Artista> artistas;
	 
	 public Cancion(String...values) {
		 //7 líneas
		 //...
	 }
	 
	 public Cancion(String titulo) {
		//6 líneas
		//...
	 }
	 
	 public String getTitulo() {
		 return this.titulo;
	 }
	 
	 public int getDuracion() {
		 return this.duracion;
	 }
	 
	 public String getFechaLanzamiento() {
		 return this.fechaLanzamiento;
	 }
	 
	 public boolean getExplicit() {
		 return this.explicit;
	 }
	 
	 public String getGenero() {
		 return this.genero;
	 }

	 public void addArtistas(Artista...artistas) {
		 if (this.artistas == null) return;
		 //1 for()
		 //...
	 }
	 
	 public ArrayList<String> getNombresArtistas() {
		 if (this.artistas == null) return null;
		 ArrayList<String> result = new ArrayList<>();
		 //1 for()
		 //...
		return result;
	 }
	 
	 public void clear() {
		 //2 líneas
		 //...
	 }
	 
	 @Override
	 public String toString() {
		 return //...
	 }
	 
	 @Override
	 public boolean equals(Object otro) {
		 //Clave -> atributo titulo
		 //4 líneas
		 //...
	 }
}