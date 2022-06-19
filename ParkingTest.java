

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ParkingTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ParkingTest
{
    /**
     * Default constructor for test class ParkingTest
     */
    public ParkingTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void carA()
    {
        Parking parking = new Parking();
        ParkingSpot spot = parking.getSpotByName("A1");
        if (!spot.getVacancy()) {
            spot.releaseParkingSpot();
        }
        
        String carPlate = DataManager.carPlateGenerator();
        String carColour = DataManager.carColourGenerator();
        String carDriver = DataManager.carDriverGenerator();
        
        spot.takeParkingSpot(carDriver, carColour, carPlate);
        
        assertEquals(carPlate, spot.getCarPlate());
        assertEquals(carColour, spot.getCarColour());
        assertEquals(carDriver, spot.getCarDriver());
    }
    
    @Test
    public void carB()
    {
        Parking parking = new Parking();
        ParkingSpot spot = parking.getSpotByName("B2");
        if (!spot.getVacancy()) {
            spot.releaseParkingSpot();
        }
        
        String carPlate = DataManager.carPlateGenerator();
        String carColour = DataManager.carColourGenerator();
        String carDriver = DataManager.carDriverGenerator();
        
        spot.takeParkingSpot(carDriver, carColour, carPlate);
        
        spot.releaseParkingSpot();
        
        assertEquals("", spot.getCarPlate());
        assertEquals("", spot.getCarColour());
        assertEquals("", spot.getCarDriver());
    }
    
    /*
    @Test
    public void carC()
    {
        Parking parking = new Parking();
        for (int i = 0; i < 5; i++) {
            parking.getSpotByName("A" + (i + 1)).takeParkingSpot(DataManager.carDriverGenerator(), DataManager.carColourGenerator(), DataManager.carPlateGenerator());
        }
        
        // ParkingSpot spot = parking;
        if (!spot.getVacancy()) {
            spot.releaseParkingSpot();
        }
        
        String carPlate = DataManager.carPlateGenerator();
        String carColour = DataManager.carColourGenerator();
        String carDriver = DataManager.carDriverGenerator();
        
        spot.takeParkingSpot(carDriver, carColour, carPlate);
        
        spot.releaseParkingSpot();
        
        assertEquals("", spot.getCarPlate());
        assertEquals("", spot.getCarColour());
        assertEquals("", spot.getCarDriver());
    }
    */
}

