package bg.sofia.uni.fmi.mjt.smartcity;

import bg.sofia.uni.fmi.mjt.smartcity.device.SmartDevice;
import bg.sofia.uni.fmi.mjt.smartcity.device.SmartLamp;
import bg.sofia.uni.fmi.mjt.smartcity.device.SmartTrafficLight;

import java.time.LocalDateTime;

public class Demo {
    public static void main(String[] args) {
        SmartLamp lamp1= new SmartLamp("1",15, LocalDateTime.now());
        System.out.println(lamp1.getId());
        SmartLamp lamp2= new SmartLamp("1",15, LocalDateTime.now());
        System.out.println(lamp2.getId());
        SmartTrafficLight smartTrafficLight1=new SmartTrafficLight("1", 4,LocalDateTime.now());
        System.out.println(smartTrafficLight1.getId());
    }

}
