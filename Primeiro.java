package jumentacareca;
import robocode.*;
import java.awt.Color;

 public class Primeiro extends AdvancedRobot {
    public void run() {
	    setBodyColor(Color.black);
	    setGunColor(Color.red);
	    setRadarColor(Color.black);
	    setScanColor(Color.red);
	    setBulletColor(Color.pink);
	
	    while(true){ 	
   		    setAhead(100);
		    setTurnLeft(90);
		    setAhead(200);
		    setTurnGunRight(90);
		    execute();
	    }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        if(e.getDistance() < 50 && getEnergy() > 50) {
	        setFire(30);
	    } else {
		    setFire(2);
		    scan();
		 
		    double angulo = e.getBearing();
		    double distancia = e.getDistance();
			
	    	if(distancia < 200) {
		        setTurnGunRight(angulo);
		        setFire(10);
		    }
	    }
    }

    public void onHitByBullet(HitByBulletEvent e){
	    back(20);
    }

    public void onHitWall(HitWallEvent e){
	    back(50);
	    turnLeft(90);
    }

    public void onHitRobot(HitRobotEvent e){
    	turnRight(e.getBearing());
	    setFire(3);
    }
    public void onWin(WinEvent e) {
	    setTurnRight(36000);
    }

    public void reverseDirection(boolean movingForward) {
		if(movingForward) {
			setBack(40000);
			movingForward = false;
		} else {
			setAhead(40000);
			movingForward = true;
		}
	}
}