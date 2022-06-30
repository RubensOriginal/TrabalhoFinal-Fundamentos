

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
    public void parkACarInParking()
    {
        Parking parking = new Parking();
        ParkingSpot spot = parking.getSpotByName("A1");
        if (!spot.getVacancy()) {
            spot.releaseSpot();
        }
        
        String carPlate = DataManager.carPlateGenerator();
        String carColour = DataManager.carColourGenerator();
        String carDriver = DataManager.carDriverGenerator();
        
        spot.takeSpot(carDriver, carColour, carPlate);
        
        assertEquals(carPlate, spot.getCarPlate());
        assertEquals(carColour, spot.getCarColour());
        assertEquals(carDriver, spot.getCarDriver());
    }
    
    @Test
    public void parkACarInParkingAndReleaseIt()
    {
        Parking parking = new Parking();
        ParkingSpot spot = parking.getSpotByName("B2");
        if (!spot.getVacancy()) {
            spot.releaseSpot();
        }
        
        String carPlate = DataManager.carPlateGenerator();
        String carColour = DataManager.carColourGenerator();
        String carDriver = DataManager.carDriverGenerator();
        
        spot.takeSpot(carDriver, carColour, carPlate);
        
        spot.releaseSpot();
        
        assertEquals("", spot.getCarPlate());
        assertEquals("", spot.getCarColour());
        assertEquals("", spot.getCarDriver());
    }
    
    @Test
    public void parkACarInParkingAfterOtherCarsAndReleaseIt()
    {
        Parking parking = new Parking();
        for (int i = 0; i < 5; i++) {
            parking.getSpotByName("A" + (i + 1)).takeSpot(DataManager.carDriverGenerator(), DataManager.carColourGenerator(), DataManager.carPlateGenerator());
        }
        
        ParkingSpot spot = parking.getSpotByName("A5");
        if (!spot.getVacancy()) {
            spot.releaseSpot();
        }
        
        String carPlate = DataManager.carPlateGenerator();
        String carColour = DataManager.carColourGenerator();
        String carDriver = DataManager.carDriverGenerator();
        
        spot.takeSpot(carDriver, carColour, carPlate);
        
        spot.releaseSpot();
        
        assertEquals("", spot.getCarPlate());
        assertEquals("", spot.getCarColour());
        assertEquals("", spot.getCarDriver());
    }
    
    @Test
    public void parkACarInAParkWithFewFreeSpotAndDiscoverItSpotUsingCarPlate() {
        Parking parking = new Parking();
        parking.fillParking();
        
        ParkingSpot spot = parking.getFirstFreeParkingSpot();
        
        String carPlate = DataManager.carPlateGenerator();
        
        spot.takeSpot(DataManager.carDriverGenerator(), DataManager.carColourGenerator(), carPlate);
        
        ParkingSpot spotFoundUsingCarPlate = parking.getSpotByPlate(carPlate);
        
        assertEquals(spotFoundUsingCarPlate, spot);
        
    }
    
    @Test
    public void parkACarInAParkWithFewFreeSpotAndDiscoverItSpotUsingCarDriver() {
        Parking parking = new Parking();
        parking.fillParking();
        
        ParkingSpot spot = parking.getFirstFreeParkingSpot();
        
        String carDriver = DataManager.carDriverGenerator();
        
        spot.takeSpot(carDriver, DataManager.carColourGenerator(), DataManager.carPlateGenerator());
        
        ParkingSpot spotFoundUsingDriverName = parking.getSpotByDriverName(carDriver);
        
        assertEquals(spotFoundUsingDriverName, spot);
        
    }
    
    @Test
    public void checkingStatisticData() {
        Parking parking = new Parking();
        parking.fillParking();
        
        StatisticData data = parking.getStatisticData();
        
        StatisticData generatedData = new StatisticData(26, 63);
        
        assertEquals(data.getNumberFreeSpots(), generatedData.getNumberFreeSpots());
        assertEquals(data.getNumberOccupiedSpots(), generatedData.getNumberOccupiedSpots());
        assertEquals(data.getPercentageFreeSpots(), generatedData.getPercentageFreeSpots());
        assertEquals(data.getPercentageOccupiedSpots(), generatedData.getPercentageOccupiedSpots());
    }
}

