package domain;

import java.util.*;

public class Sale {
	private Vector lineItems;
	private Date date;
	private boolean isComplete;
	private Payment payment;
	
	public Sale () {
		lineItems = new Vector();
		date = new Date();
		isComplete = false;
	}

	public float getBalance()
	{
		return payment.getAmount() - total();
	}

	public void becomeComplete()
	{
		isComplete = true;
	}

	public boolean isComplete() { return isComplete; }

	public void makeLineItem( ProductSpecification spec, int quantity )
	{
		lineItems.addElement( new SaleLineItem( spec, quantity ) );
	}

	public float total()
	{
		Enumeration	e = lineItems.elements();

		return sumAllElements(e);
	}

	//ref-1 se suman todos precios las lineas de venta
	private float sumAllElements(Enumeration e) {
		float total = 0;
		while( e.hasMoreElements() )
		{
			total += ( (SaleLineItem) e.nextElement() ).subtotal();
		}
		return total;
	}

	public void makePayment( float cashTendered )
	{
		payment = new Payment( cashTendered );
	}
}
