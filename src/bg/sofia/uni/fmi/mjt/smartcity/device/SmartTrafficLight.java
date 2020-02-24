package bg.sofia.uni.fmi.mjt.smartcity.device;

import bg.sofia.uni.fmi.mjt.smartcity.enums.DeviceType;

import java.time.LocalDateTime;

public class SmartTrafficLight extends Device {

    private  static int id=0;
    private int currentId=id;

    public SmartTrafficLight(String name, double powerConsumption, LocalDateTime installationDateTime) {
        super(name, powerConsumption, installationDateTime,id++);
        type=DeviceType.TRAFFIC_LIGHT;
        //id++;
    }
   /* @Override
    public String getId() {
        String newId= type.getShortName()+"-"+this.getName()+"-"+this.currentId;
        return newId;
    }*/
}
