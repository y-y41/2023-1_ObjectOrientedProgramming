package lab08;

import java.time.LocalDate;

public class ICE extends Car{
    private static int carNum;
    private static int CO2emission;
    private static final int GHGPERCAR = 35;

    ICE() {
        super();
    }

    ICE(String name, LocalDate date, int carNum) {
        this.name = name;
        this.date = date;
        ICE.carNum += carNum;
        ICE.CO2emission += carNum*ICE.GHGPERCAR;
    }

    public boolean equals(Object obj) {
        ICE ICEobj = (ICE)obj;
        if (this.name.equals(ICEobj.name)) if (this.date.equals(ICEobj.date))
            return true;
        return false;
    }

    public String toString() {
        return "name: "+this.name+", date: "+this.date+", carNum: "+ carNum;
    }

    int totalCO2() {
        System.out.println("ICE emit CO2 most when driving");
        return CO2emission;
    }
}
