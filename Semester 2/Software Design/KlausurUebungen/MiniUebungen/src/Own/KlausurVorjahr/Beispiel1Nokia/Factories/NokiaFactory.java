package Own.KlausurVorjahr.Beispiel1Nokia.Factories;

import Own.KlausurVorjahr.Beispiel1Nokia.ProductType;
import Own.KlausurVorjahr.Beispiel1Nokia.Products.Product;

public abstract class NokiaFactory {

	public abstract Product produce(ProductType productType);

	// Methodensignatur bitte nicht verändern!!
	public Product getProduct(ProductType type) {

		Product c = null;

		// hier darf programmiert werden
		c = produce(type);

		// wenn default ausgelöst wurde, wurde c nicht definiert und gibt dann null zurück
		if (c == null) {
			return null;
		}
		
		// AB HIER NICHT MEHR VERÄNDERN
		// JEDES Produkt muss eine Seriennummer erhalten
		c.addSerialNumber();
		
		return c;
	}
}
