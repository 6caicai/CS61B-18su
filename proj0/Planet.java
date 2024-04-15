import java.lang.Math;

public class Planet{
	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet P){
		xxPos = P.xxPos;
		yyPos = P.yyPos;
		xxVel = P.xxVel;
		yyVel = P.yyVel;
		mass = P.mass; 
		imgFileName = P.imgFileName;
	}

	public double calcDistance(Planet P){
        double x = xxPos - P.xxPos; 
  		double y = yyPos - P.yyPos;
        return(Math.sqrt(x * x + y * y));
    }

    public double calcForceExertedBy(Planet P){
    	double G = 6.67e-11;
    	double distance = calcDistance(P);
    	return (G * mass * P.mass) / (distance * distance);
    }

    public double calcForceExertedByX(Planet P){
    	double F = calcForceExertedBy(P);
    	return (F * (P.xxPos - xxPos) / calcDistance(P));
    }


    public double calcForceExertedByY(Planet P){
    	double F = calcForceExertedBy(P);
    	return (F * (P.yyPos - yyPos) / calcDistance(P));
    }

    public double calcNetForceExertedByX(Planet[] P){
    	int length = P.length;
    	double result = 0;
    	for (int i = 0; i < length; i++){
    		if (this.equals(P[i])){
    			continue;
    		}
    		else{
    			result += calcForceExertedByX(P[i]);
    		}
    	}
    	return result;
    }

    public double calcNetForceExertedByY(Planet[] P){
    	int length = P.length;
    	double result = 0;
    	for (int i = 0; i < length; i++){
    		if (this.equals(P[i])){
    			continue;
    		}
    		else{
    			result += calcForceExertedByY(P[i]);
    		}
    	}
    	return result;
    }

    public void update(double t, double Fx, double Fy){
    	double ax = Fx / mass;
    	double ay = Fy / mass;
    	xxVel += ax * t;
    	yyVel += ay * t;
    	xxPos += t * xxVel;
    	yyPos += t * yyVel;
    }

    public void draw(){
    	StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}