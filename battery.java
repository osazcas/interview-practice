class Battery {

    double efficiency = 0.9;
    double maxEnergy = 100; //max energy capacity in kWh
        

    public static void main(String[] args) {
        Battery bat = new Battery();
        double[] timeArray = new double[]{0, 1, 1.5, 2, 2.5}; //time vector in hours
        double[] powerArray = new double[]{0, 50, -25, -25, -25}; //power vector in kW
        double currentSoC = 0.8;
        double pastSoC = currentSoC;
        System.out.println("Printing SoC level for each time..");
        for(int i = 1; i < timeArray.length; i++) 
        {
            currentSoC = bat.getSoC(pastSoC, powerArray[i-1], timeArray[i-1], timeArray[i]); 
            System.out.println("time: " + 
                                timeArray[i] + 
                                " power: " + 
                                powerArray[i] + 
                                " soc: " +
                                currentSoC);
            pastSoC = currentSoC;
        } 
    }

    double getSoC(double soc1, double power1, double time1, double time2)
    {
        if (power1 > 0)
        {
            return (soc1 - (power1/this.efficiency*(time2-time1))/this.maxEnergy);
        }
        else
        {
            return (soc1 - (power1*this.efficiency*(time2-time1))/this.maxEnergy);
        }
    }
}