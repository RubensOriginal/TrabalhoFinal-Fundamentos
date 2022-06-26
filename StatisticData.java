public class StatisticData {
    
    private int numberFreeSpots;
    private int numberOccupiedSpots;
    
    private double percentageFreeSpots;
    private double percentageOccupiedSpots;
    
    public StatisticData(int freeSpots, int occupiedSpots) {
        int totalSpots = freeSpots + occupiedSpots;
        
        this.numberFreeSpots = freeSpots;
        this.numberOccupiedSpots = occupiedSpots;
        
        this.percentageFreeSpots = (freeSpots * 100.0) / (double) totalSpots;
        this.percentageOccupiedSpots = (occupiedSpots * 100.0) / (double) totalSpots;
    }
    
    public int getNumberFreeSpots() {
        return this.numberFreeSpots;
    }
    
    public int getNumberOccupiedSpots() {
        return this.numberOccupiedSpots;
    }
    
    public double getPercentageFreeSpots() {
        return this.percentageFreeSpots;
    }
    
    public double getPercentageOccupiedSpots() {
        return this.percentageOccupiedSpots;
    }
}
