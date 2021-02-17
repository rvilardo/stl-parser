
package com.rvilardo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * Unit test for <code>Triangle3</code>.
 * 
 * @author rafaelvilardo
 *
 */
public class TriangleTest {

    private Triangle triangule;

    @BeforeEach                                         
    public void setUp() throws Exception {
		Vector3 v1 = new Vector3(0, 0, 0);
		Vector3 v2 = new Vector3(1, 0, 0);
		Vector3 v3 = new Vector3(1, 1, 1);
		
		triangule = new Triangle(v1, v2, v3);
    }
	
	@Test
	public void testInit() {
		assertEquals(3, triangule.getVertices().length);
	}
	
	@Test
	public void testArea() {
		assertEquals(0.7071067811865476, triangule.getArea());
	}
	
}
