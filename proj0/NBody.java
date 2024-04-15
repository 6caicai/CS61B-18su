public class NBody{


	public static double readRadius(String args){
		In in = new In(args);
		int planets_number = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String args){
		In in = new In(args);
		int planets_number = in.readInt();
		double radius = in.readDouble();
		Planet[] planets_array = new Planet[planets_number];
		for(int i = 0; i < planets_number; i += 1){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets_array[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
		}
		return planets_array;
	}

	public static void main(String[] agrs){

		// read about the file info
		double T = Double.parseDouble(agrs[0]);
		double dt = Double.parseDouble(agrs[1]);
		String filename = agrs[2];
		Planet[] planet = readPlanets(filename);
		double radius = readRadius(filename);

		// draw the background
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");

		// draw planets
		int planets_number = planet.length;
		for(int i = 0; i < planets_number; i += 1){
			planet[i].draw();
		}

		StdDraw.enableDoubleBuffering();

		int time = 0;
		while(time < T){
			double[] xForces = new double[planet.length];
			double[] yForces = new double[planet.length];
			for (int i = 0; i < planet.length; i += 1){
				xForces[i] = planet[i].calcNetForceExertedByX(planet);
				yForces[i] = planet[i].calcNetForceExertedByY(planet);
			}	
			for (int i = 0; i < planet.length; i += 1){
				planet[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, "images/starfield.jpg");

			// draw planets
			for(int i = 0; i < planets_number; i += 1){
				planet[i].draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}

		StdOut.printf("%d\n", planet.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planet.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  		planet[i].xxPos, planet[i].yyPos, planet[i].xxVel,
                  		planet[i].yyVel, planet[i].mass, planet[i].imgFileName);   
}
	}
}