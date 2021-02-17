package com.rvilardo.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.rvilardo.exception.NotVertexException;
import com.rvilardo.model.Report;
import com.rvilardo.model.Vector3;

public class STLParserTest {

	@Test
	public void testReadBufferedSample() {
		String path = "src/test/resources/Sample.stl";

		File file = new File(path);
		Report report = STLParser.readBuffered(file.toPath());

		assertEquals(2, report.getNumberOfTriangles());
	}

	@Test
	public void testReadBufferedMoon() {
		String path = "src/test/resources/Moon.stl";

		File file = new File(path);
		Report report = STLParser.readBuffered(file.toPath());

		assertEquals(116, report.getNumberOfTriangles());
	}

	@Test
	public void testProcessVertex() throws NotVertexException {
		String vertexLine = "vertex 1 0 1";

		Vector3 vertex = STLParser.processVertex(vertexLine);

		assertEquals(1, vertex.x);
		assertEquals(0, vertex.y);
		assertEquals(1, vertex.z);
	}

	@Test
	void testProcessNotVertexException() {
		Assertions.assertThrows(NotVertexException.class, () -> {
			STLParser.processVertex("solid");
		});

		Assertions.assertThrows(NotVertexException.class, () -> {
			STLParser.processVertex("");
		});
	}

}
