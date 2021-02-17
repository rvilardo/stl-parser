package com.rvilardo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportTest {

	private Report report;

	@BeforeEach
	public void setUp() throws Exception {
		report = new Report("test");
	}

	@Test
	public void testReport() {
		Vector3 v1;
		Vector3 v2;
		Vector3 v3;

		v1 = new Vector3(0, 0, 0);
		v2 = new Vector3(1, 0, 0);
		v3 = new Vector3(1, 1, 1);

		report.addTriangule(new Triangle(v1, v2, v3));

		v1 = new Vector3(0, 0, 0);
		v2 = new Vector3(0, 1, 1);
		v3 = new Vector3(1, 1, 1);

		report.addTriangule(new Triangle(v1, v2, v3));

		assertEquals(2, report.getNumberOfTriangles());
		assertEquals(1.4142135623730951, report.getArea());
	}

}
