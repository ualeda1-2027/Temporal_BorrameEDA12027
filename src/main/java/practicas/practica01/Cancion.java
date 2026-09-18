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
		 if (values.length != 5	) throw new RuntimeException("Formato: título,duración en segundos, fecha de lanzamiento, contenido explícito, género");
		 this.titulo = values[0];
		 this.duracion = Integer.parseInt(values[1]);
		 this.fechaLanzamiento = Format.formatFecha(values[2]);
		 this.explicit = Boolean.parseBoolean(values[3]);
		 this.genero = values[4];
		 this.artistas = new ArrayList<>();
	 }
	 
	 public Cancion(String titulo) {
		 this.titulo = titulo;
		 this.duracion = -1;
		 this.fechaLanzamiento = null;
		 this.explicit = false;
		 this.genero = null;
		 this.artistas = null;
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
		 for (Artista artista: artistas) {
			 if (this.artistas.contains(artista)) continue;
			 this.artistas.add(artista);
		 }
	 }
	 
	 public ArrayList<String> getNombresArtistas() {
		 if (this.artistas == null) return null;
		 ArrayList<String> result = new ArrayList<>();
		
		 for (Artista artista: this.artistas) {
			 result.add(artista.getNombre());
		 }
		return result;
	 }
	 
	 public void clear() {
		 if (this.artistas == null) return;
		 this.artistas.clear();
	 }
	 
	 @Override
	 public String toString() {
		 return this.titulo + " --> " + (this.artistas == null ? "[]" : this.getNombresArtistas().toString());
	 }
	 
	 @Override
	 public boolean equals(Object otro) {
		 if (otro == null) return false;
		 if (this == otro) return true;
		 if (!(otro instanceof Cancion)) return false;
		 return this.titulo.equals(((Cancion)otro).titulo);
	 }
}