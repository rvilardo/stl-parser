package com.rvilardo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * Unit test for <code>Vector3<code>.
 * 
 * @author rafaelvilardo
 *
 */
public class Vector3Test {

	@Test
	public void testInit() {
		Vector3 v = new Vector3(0, 1, 0);
		
		assertEquals(0, v.x);
		assertEquals(1, v.y);
		assertEquals(0, v.z);
	}
	
	@Test
	public void testSub() {
		Vector3 v1 = new Vector3(0, 1, 0);
		Vector3 v2 = new Vector3(1, 0, 0);
		Vector3 res = v2.sub(v1);
		
		assertEquals(1, res.x);
		assertEquals(-1, res.y);
		assertEquals(0, res.z);
	}
	
	@Test
	public void testCross() {
		Vector3 v1 = new Vector3(0, 1, 0);
		Vector3 v2 = new Vector3(1, 0, 0);
		Vector3 res = Vector3.cross(v2, v1);
		
		assertEquals(1, res.x);
		assertEquals(0, res.y);
		assertEquals(0, res.z);
	}

	@Test
	public void testLength() {
		Vector3 v = new Vector3(1, 1, 1);
		Double res = v.length();
		
		assertEquals("1.73", String.format("%.2f", res));
	}
	
}
