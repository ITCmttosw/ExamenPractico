package domain;

import java.util.*;

public class ProductCatalog {
  private Hashtable productSpecifications = new Hashtable();

  public ProductCatalog() {
	  generateSpecifications();
  }

  //Genera las especificaciones de los productos
private void generateSpecifications() {
	ProductSpecification ps;
	for (int i = 1 ; i <= 4 ; i++ ){
		  ps = new ProductSpecification(i, i*100, "product " + i);
		  productSpecifications.put(new Integer(i), ps);
	  }
}

  public ProductSpecification specification(int upc) {
    return (ProductSpecification) productSpecifications.get(new Integer(upc));
  }
}
