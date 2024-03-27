package lab11;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.lang.reflect.Field;

public class ServiceManagement {
    public static <T extends Hub> int findIndexByNum(ArrayList<T> tList, int num) {
        int idx=0;
        for (T t: tList) {
            if(t.getNumber() == num) return idx;
            idx++;
        }
        return -1;
    }

    public static <T extends Hub> T raisePerBox(T t, double rate) {
        //택배박스개당요금변경,e.g.1.05==5%상승
        t.setPricePerBox(t.getPricePerBox() * rate);
        return t;
    }

    public static <T extends Hub> ArrayList<T> raiseAll(Class<T> c, ArrayList<T> tList, double rate) {
        //tList의모든박스요금변경,e.g.1.05==5%상승
        for (T elem : tList) {
            //아래메소드는자신이정한메소드이름에맞게변경
            elem.setPricePerBox(rate * elem.getPricePerBox());
        }
        //해당지역허브의기본택배요금변경
        try {
            Field f = c.getField("init_price_per_box");
            double value = f.getDouble(null);
            f.setDouble(null, value * rate); // no need to be an object, because it is static variable.
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return tList;

    }

    public static <T extends Hub> void packageBoxes(String[] descriptions, Class<T> classType, ArrayList<T> tList) {
        try{
            Constructor<T> constructor = classType.getConstructor(String.class);
            for (String str : descriptions) {
                T myHub = constructor.newInstance(str);
                tList.add(myHub);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T extends Hub, U extends Hub> void changeHub(
            ArrayList<T> tList, int index, Class<U> classtype, ArrayList<U> uList
    ) {
        try {
            T originalHub = tList.get(index);
            String bubDescription = originalHub.getDescription();
            Constructor<U> constructor = classtype.getConstructor(String.class);
            U newHub = constructor.newInstance(bubDescription);
            tList.set(index, null);
            newHub.setPricePerBox(0.9*newHub.getPricePerBox());
            uList.add(newHub);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
