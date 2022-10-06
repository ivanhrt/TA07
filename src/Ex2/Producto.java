package Ex2;

public class Producto {
	private double precioBruto;
	private int stock;
	private double tipoIva;
	
	public Producto(double precioBruto,int stock,double tipoIva) {
		this.precioBruto=precioBruto;
		this.stock=stock;
		this.tipoIva=tipoIva;
	}
	
	
	public double getPrecioBruto() {
		return precioBruto;
	}
	
	public void setPrecioBruto(double precioBruto) {
		this.precioBruto = precioBruto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getTipoIva() {
		return tipoIva;
	}

	public void setTipoIva(double tipoIva) {
		this.tipoIva = tipoIva;
	}
	
	

}
