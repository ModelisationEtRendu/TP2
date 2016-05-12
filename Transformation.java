/**
 * author: cdehais
 */

import algebra.*;

public class Transformation  {

    Matrix worldToCamera;
    Matrix projection;
    Matrix calibration;

    public Transformation () {
        try {
            worldToCamera = new Matrix ("W2C", 4, 4);
            projection = new Matrix ("P", 3, 4);
            calibration = Matrix.createIdentity (3);
            calibration.setName ("K");
        } catch (InstantiationException e) {
            /* should not reach */
        }
    }

    public void setLookAt (Vector3 cam, Vector3 lookAt, Vector3 up) {
        try {
            worldToCamera = Matrix(4, 4);
            
		    // compute rotation
            Vector3 z = lookat.clone();
            z.substract(cam);
            z.normalize();
            Vector3 x = up.cross(z);
            x.normalize();
            Vector3 y = z.cross(x);
            worldToCamera.set(0, 0, x.getX());
            worldToCamera.set(1, 0, x.getY());
            worldToCamera.set(2, 0, x.getZ());
            worldToCamera.set(0, 1, y.getX());
            worldToCamera.set(1, 1, y.getY());
            worldToCamera.set(2, 1, y.getZ());
            worldToCamera.set(0, 2, z.getX());
            worldToCamera.set(1, 2, z.getY());
            worldToCamera.set(2, 2, z.getZ());
            worldToCamera.set(0, 3, cam.getX());

			// compute translation
            worldToCamera.set(1, 3, cam.getY());
            worldToCamera.set(2, 3, cam.getZ());
            wolrdToCamera.set(3, 3, 1);

        } catch (Exception e) { /* unreached */ };
        
        System.out.println ("Modelview matrix:\n" + worldToCamera);
    }

    public void setProjection () {
		projection = Matrix(3, 4);
		
		projection.set(0, 0, 1);
        projection.set(1, 1, 1);
        projection.set(2, 2, 1);
 
        System.out.println ("Projection matrix:\n" + projection);
    }

    public void setCalibration (double focal, double width, double height) {
		calibration = Matrix(3, 3);
		
		calibration.set(0, 0, focal);
		calibration.set(1, 1, focal);
		calibration.set(2, 2, 1);
		calibration.set(0, 2, widht/2);
		calibration.set(1, 2, height/2);

        System.out.println ("Calibration matrix:\n" + calibration);
    }

    /**
     * Projects the given homogeneous, 4 dimensional point onto the screen.
     * The resulting Vector as its (x,y) coordinates in pixel, and its z coordinate
     * is the depth of the point in the camera coordinate system.
     */  
    public Vector3 projectPoint (Vector p)
        throws SizeMismatchException, InstantiationException {
	Vector ps = new Vector(3);

        /* à compléter */

	return new Vector3 (ps);
    }
    
    /**
     * Transform a vector from world to camera coordinates.
     */
    public Vector3 transformVector (Vector3 v)
        throws SizeMismatchException, InstantiationException {
        /* Doing nothing special here because there is no scaling */
        Matrix R = worldToCamera.getSubMatrix (0, 0, 3, 3);
        Vector tv = R.multiply (v);
        return new Vector3 (tv);
    }
    
}

