package com.rvilardo;

import java.io.File;

import com.rvilardo.model.Report;
import com.rvilardo.parser.STLParser;

/**
 * Entry point for STL parser.
 * @author rafaelvilardo
 *
 */
public class MainApp {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No arguments were given. Please provide a path to a STL file.");
			System.exit(0);
		}

		try {
			File f = new File(args[0]);
			if (f.exists()) {
				Report report = STLParser.parseSTLFile(f.toPath());
				System.out.println("Number of triangles: " + report.getNumberOfTriangles());
				System.out.println("Surface Area: " + report.getArea());
			} else {
				System.out.println("File [" + args[0] + "] does not exist. Please provide a valid STL file path.");
			}
		} catch (Exception e) {
			System.out.println("Error parsing provided STL file: " + e.getMessage());
			System.exit(e.hashCode());
		}
	}

}
