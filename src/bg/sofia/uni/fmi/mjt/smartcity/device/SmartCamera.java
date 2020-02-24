package bg.sofia.uni.fmi.mjt.smartcity.device;

import bg.sofia.uni.fmi.mjt.smartcity.enums.DeviceType;

import java.time.LocalDateTime;

public class SmartCamera extends Device {


    private static int id=0;
    //private int currentId=id;

  /*  @Override
    public String getId() {
        String newId= type.getShortName()+"-"+this.getName()+"-"+this.currentId;
        return newId;
    }*/

    public SmartCamera(String name, double powerConsumption, LocalDateTime installationDateTime) {
        super(name,powerConsumption,installationDateTime, id++);
        type=DeviceType.CAMERA;
       // id++;
    }


}
