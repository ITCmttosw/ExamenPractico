package testExamenPractico;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import workflow.POST;
import domain.Store;

public class testUnit {
	POST post;
	@Before
	public void setUp() throws Exception {
		Store tienda = new Store();
		post = tienda.getPOST();
	}

	@Test
	public void testTotal() {
		post.EnterItem(1, 5);
		post.EnterItem(2, 5);
		post.EnterItem(3, 5);
		post.EnterItem(4, 5);
		post.endSale();
		Assert.assertTrue(post.getSale().total() == 5000);
	}

}
