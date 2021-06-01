import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Floydtest {
	@Test
	void test() {
		Floyd gg= new Floyd();
		gg.add("City1","City2","1");
		gg.add("City2","City4","2");
		gg.add("City4","City6","3");
		gg.add("City3","City8","4");
		gg.add("City5","City10","5");
	}
	
	void agregartest() {
		gg.agregar("City1","City2");
		assertEquals(0,gg.recorrido("City1","City2"));
	}
	
	void existetest() {
		gg.existe("City1","City3");
		
		return true 
	}
	
	void shorter_rutetest() {
		gg.shorter_rute();
		assertEquals(3,gg.recorrido("City2","City4"));	
	}
	
	void centertest() {
		gg.center();
		assertEquals("city4");
		}
	
	void cercatest() {
		gg.cerca("City1","City2");
		assertEquals("City4");
		}
	
	void recorridotest() {
		gg.cerca("City1","City2");
		assertEquals(1);
	}
	

}
