package lab08;

import java.time.LocalDate;

public class BEV extends Car{
    private static int carNum;
    private static int CO2emission;
    private static final int GHGPERCAR = 25;

    BEV() {
        super();
    }

    BEV(String name, LocalDate date, int carNum) {
        this.name=name;
        this.date = date;
        BEV.carNum += carNum;
        BEV.CO2emission += carNum*BEV.GHGPERCAR;
    }

    public boolean equals(Object obj) {
        BEV BEVobj = (BEV)obj;
        if (this.name.equals(BEVobj.name) && this.date.equals(BEVobj.date))
            return true;
        return false;
    }

    public String toString() {
        return "name: "+this.name+", date: "+this.date+", carNum: "+carNum;
    }

    int totalCO2() {
        System.out.println("BEV emit CO2 most when generation electric energy");
        return CO2emission;
    }
}
