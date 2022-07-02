public class StatisticData {
    
    private int numberFreeSpots;
    private int numberOccupiedSpots;
    private int numberTotalSpots;
    
    private double percentageFreeSpots;
    private double percentageOccupiedSpots;
    
    public StatisticData(int freeSpots, int occupiedSpots) {
        numberTotalSpots = freeSpots + occupiedSpots;
        
        this.numberFreeSpots = freeSpots;
        this.numberOccupiedSpots = occupiedSpots;
        
        this.percentageFreeSpots = (freeSpots * 100.0) / (double) numberTotalSpots;
        this.percentageOccupiedSpots = (occupiedSpots * 100.0) / (double) numberTotalSpots;
    }
    
    public int getNumberFreeSpots() {
        return this.numberFreeSpots;
    }
    
    public int getNumberOccupiedSpots() {
        return this.numberOccupiedSpots;
    }
    
    public int getNumberTotalSpots() {
        return this.numberTotalSpots;
    }
    
    public double getPercentageFreeSpots() {
        return this.percentageFreeSpots;
    }
    
    public double getPercentageOccupiedSpots() {
        return this.percentageOccupiedSpots;
    }
}
