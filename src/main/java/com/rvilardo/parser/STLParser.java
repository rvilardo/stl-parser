package com.rvilardo.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.StringTokenizer;

import com.rvilardo.exception.NotVertexException;
import com.rvilardo.model.Report;
import com.rvilardo.model.Triangle;
import com.rvilardo.model.Vector3;

/**
 * STL parser for text files.
 * 
 * @author rafaelvilardo
 *
 */
public class STLParser {

	/**
	 * Token that identifies a vertex to be parsed.
	 */
	private static final String VERTEX = "vertex";

	/**
	 * Parses an text STL file.
	 * 
	 * @param filePath The file to parse
	 * @return A list of triangles with all triangles in the STL file.
	 * 
	 */
	public static Report parseSTLFile(Path filePath) {
		// Profiling...
//		Instant start = Instant.now();
//		Report r = readBuffered(filePath);
//		Instant end = Instant.now();
//		System.out.println(Duration.between(start, end));

		return readBuffered(filePath);
	}

	/**
	 * Reads a STL text file using <code>BufferedReader</code> technique in order to
	 * extract a list of triangles.
	 * 
	 * @param filePath The file to parse
	 * @return A list of triangles representing all of the triangles in the STL
	 *         file.
	 */
	static Report readBuffered(Path filePath) {
		Report report = new Report(filePath.toString());

		try (BufferedReader br = new BufferedReader(new FileReader(filePath.toString()))) {
			Vector3[] vertices = new Vector3[3];
			int v = 0;
			String line;
			while ((line = br.readLine()) != null) {
				try {
					vertices[v] = processVertex(line);
					v++;
					if (v == vertices.length) {
						report.addTriangule(new Triangle(vertices[0], vertices[1], vertices[2]));
						v = 0;
						vertices = new Vector3[3];
					}
				} catch (NotVertexException e) {
					continue;
				}
			}

		} catch (Exception e) {
			throw new RuntimeException("Parse failed.");
		}
		return report;
	}

	/**
	 * Process a vertex line returning its vector3 representation.
	 * 
	 * @param line to be processed
	 * @return <code>Vector3</code> representation of the line
	 * @throws NotVertexException when the line is not a vertex to be processed
	 */
	static Vector3 processVertex(String line) throws NotVertexException {
		int iv = line.indexOf(VERTEX);
		if (iv == -1) {
			throw new NotVertexException(line);
		}
		double[] vals = new double[3];
		StringTokenizer st = new StringTokenizer(line.substring(iv + VERTEX.length()).trim());
		int i = 0;
		while (st.hasMoreTokens() && i < vals.length) {
			vals[i] = Double.parseDouble(st.nextToken());
			i++;
		}
		Vector3 v = new Vector3(vals[0], vals[1], vals[2]);
		return v;
	}

}