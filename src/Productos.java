import java.io.Serializable;
import java.util.Objects;

public class Productos implements Serializable {
	
	private int codigo;
	private String marca;
	private String nombreProducto;
	private double precio;
	private int stock;
	
	public Productos(int c, String m, String np,double p, int s) 
	{
		codigo = c;
		marca = m;
		nombreProducto = np;
		precio = p;
		stock =s;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombreProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		return codigo == other.codigo && Objects.equals(nombreProducto, other.nombreProducto);
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	
	

}
