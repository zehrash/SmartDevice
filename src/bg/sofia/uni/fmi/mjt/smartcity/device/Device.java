package bg.sofia.uni.fmi.mjt.smartcity.device;

import bg.sofia.uni.fmi.mjt.smartcity.enums.DeviceType;
import bg.sofia.uni.fmi.mjt.smartcity.hub.DeviceAlreadyRegisteredException;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Device implements SmartDevice {


    public int currentId;
    private String name;
    private double powerConsumption;
    private LocalDateTime installationDateTime;
    DeviceType type;


    public  String getId() {
        String newId= type.getShortName()+"-"+getName()+"-"+this.currentId;
        return newId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPowerConsumption() {
        return powerConsumption;
    }

    public Device(String name, double powerConsumption, LocalDateTime installationDateTime, int currentId) {
        this.name = name;
        this.powerConsumption = powerConsumption;
        this.installationDateTime = installationDateTime;
        this.currentId=currentId;
    }
    @Override
    public LocalDateTime getInstallationDateTime() {
        return installationDateTime;
    }

    @Override
    public DeviceType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return currentId == device.currentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentId);
    }
}
