package auxiliar;


public class Entrada <K extends Comparable<K>,V> implements Comparable<Entrada<K,V>>{
	
	private final K clave;
	private V valor;
	
	public Entrada(K clave, V valor) {
		this.clave = clave;
		this.valor = valor;
	}

	public K getClave() {
		return this.clave;
	}

	public V getValor() {
		return this.valor;
	}
	
	public V setValor(V valor) {
		V oldValue = this.valor;
		this.valor = valor;
		return oldValue;
	}
	
	@Override
	public String toString() {
		return clave + " <" + valor + ">";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Entrada)) return false;
		return this.clave.equals(((Entrada<?,?>)o).clave);
	}
	
	@Override
	public int compareTo(Entrada<K,V> other) {
		return this.clave.compareTo(other.clave);
	}
}
