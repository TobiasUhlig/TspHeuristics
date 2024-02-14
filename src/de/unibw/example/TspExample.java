package de.unibw.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import de.unibw.tspchallenge.core.Location;
import de.unibw.tspchallenge.core.ProblemParser;
import de.unibw.tspchallenge.core.Tour;
import de.unibw.tspchallenge.gui.TourViewer;

public class TspExample {

	public static void main(String[] args) {
		/*
		 * Load a TSP problem specified by file name located in the "tsplib"
		 * directory
		 * 
		 */
		Tour myTour = ProblemParser.TourFromFile("bier127.tsp.gz");

		/*
		 * How long is this tour
		 */
		System.out.println("Tour Length = " + myTour.length());
		
		/*
		 * We should optimize the sequence of locations to minimize the length. 
		 */
		List<Location> locations = myTour.getLocations();

		// some fancy optimization to find a better order, e.g. random shuffling
		List<Location> solution = new ArrayList<>(locations);	
		Collections.shuffle(solution);
		
		
		
		/*
		 * Lets have a look whether the "optimized" sequence is better
		 */
		
		Tour myNewTour = new Tour(solution);
		System.out.println("New Tour Length = " + myNewTour.length());
		
		
		/*
		 * Finally, a simple visualization 
		 */
		
		TourViewer tv = new TourViewer();
		tv.showTour(myTour, "Initial Tour");
		tv.showTour(myNewTour, "Optimized Tour");	
		
	}
}
