package practicas.practica01;

import java.util.ArrayList;

public class Artista {
    private String nombre;
    private String ciudad;     
    private int anyo;      // año de nacimiento o de formación si es grupo
    private String imagenUrl;
    private final ArrayList<String> miembros; // solista → nombre completo; grupo → nombre de los componentes
    
    public Artista(String...values){
    	if (values.length !=4) throw new RuntimeException ("Formato: nombre, ciudad, año, imagenURL");
    	this.nombre = values[0];
    	this.ciudad = values[1];
    	this.anyo = Integer.parseInt(values[2]); 
    	this.imagenUrl = values[3];
    	this.miembros = new ArrayList<>();
    }
    
    public Artista(String nombre) {
       	this.nombre = nombre;
    	this.ciudad = null;
    	this.anyo = -1;
    	this.imagenUrl = null;
    	this.miembros =  null;
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
    	return this.miembros == null ? null : this.miembros.toString();
    }
        	
    public void addMiembros(String...miembros) {
    	if (this.miembros == null) return;
    	for (String miembro: miembros) {
    		if (miembro == null || miembro.isBlank()) continue;
    		if (this.miembros.contains(miembro)) continue;
    		this.miembros.add(miembro);
    	} 
    }
    
    public void clear() {
    	if (this.miembros == null) return;
    	this.miembros.clear();	
    }
    
    @Override
    public String toString() {
    	return this.nombre +  " --> " + (this.miembros == null ? "[]" : this.miembros.toString()); 
    }
    
    @Override
    public boolean equals(Object otro) {
    	if (otro == null) return false;
    	if (this == otro) return true;
    	if (!(otro instanceof Artista)) return false;
    	return this.nombre.equals(((Artista)otro).nombre);
    }
}