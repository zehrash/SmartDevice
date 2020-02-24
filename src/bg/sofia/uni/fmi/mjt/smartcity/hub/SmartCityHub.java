package bg.sofia.uni.fmi.mjt.smartcity.hub;

import bg.sofia.uni.fmi.mjt.smartcity.device.Device;
import bg.sofia.uni.fmi.mjt.smartcity.device.SmartDevice;
import bg.sofia.uni.fmi.mjt.smartcity.enums.DeviceType;

import java.util.*;
import java.time.Duration;
import java.time.LocalDateTime;

public class SmartCityHub {

    private LinkedHashMap<String, SmartDevice> devices;

    public SmartCityHub() {

        devices = new LinkedHashMap<>();
    }

    public void register(SmartDevice device) throws DeviceAlreadyRegisteredException {

        if (device == null) {
            throw new IllegalArgumentException();
        }
        if (!devices.containsKey(device.getId())) {
            devices.put(device.getId(), device);
        } else {
            throw new DeviceAlreadyRegisteredException();
        }
    }

    public void unregister(SmartDevice device) throws DeviceNotFoundException {
        if (device == null) {
            throw new IllegalArgumentException();
        }
        if (!devices.containsValue(device)) {
            throw new DeviceNotFoundException();
        } else {
            devices.remove(device.getId());
        }
    }

    public SmartDevice getDeviceById(String id) throws DeviceNotFoundException {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        if(!devices.containsKey(id)){
            throw new DeviceNotFoundException();
        }
        SmartDevice smartDevice = null;
        for (Map.Entry<String, SmartDevice> entry : devices.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(id)) {
                smartDevice = entry.getValue();
            }
        }
            return smartDevice;
    }

    public int getDeviceQuantityPerType(DeviceType type) {
        int counter = 0;
        if (type == null) {
            throw new IllegalArgumentException();
        }
        for (SmartDevice d : devices.values()) {
            if (d.getType().equals(type)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Returns a collection of IDs of the top @n devices which consumed
     * the most power from the time of their installation until now.
     * <p>
     * The total power consumption of a device is calculated by the hours elapsed
     * between the two LocalDateTime-s multiplied by the stated power consumption of the device.
     * <p>
     * If @n exceeds the total number of devices, return all devices available sorted by the given criterion.
     *
     * @throws IllegalArgumentException in case @n is a negative number.
     */

    public Collection<String> getTopNDevicesByPowerConsumption(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        List<Map.Entry<String, SmartDevice>> ordered = new ArrayList<>(devices.entrySet());
        Comparator<Map.Entry<String, SmartDevice>> comparatorByPowerConsumption = (Comparator<Map.Entry<String, SmartDevice>>) (o1, o2) -> {
            Duration hour1 = Duration.between(o1.getValue().getInstallationDateTime(), LocalDateTime.now());
            Duration hour2 = Duration.between(o2.getValue().getInstallationDateTime(), LocalDateTime.now());

            return Double.compare(hour1.toHours() * o2.getValue().getPowerConsumption(), hour2.toHours() * o2.getValue().getPowerConsumption());
        };
        Collections.sort(ordered, comparatorByPowerConsumption);


        ArrayList<String> keys = new ArrayList<>();
        int counter = 1;
        for (Map.Entry<String, SmartDevice> d : ordered) {
            if (counter == n) {
                break;
            }
            keys.add(d.getKey());
            counter++;
        }
        return keys;
    }

    public Collection<SmartDevice> getFirstNDevicesByRegistration(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n > devices.size()) {
            return devices.values();
        }
        ArrayList<SmartDevice> values = new ArrayList<>();
        int counter = 1;
        for (SmartDevice d : devices.values()) {
            if (counter == n) {
                break;
            }
            values.add(d);
            counter++;
        }
        return values;
    }
}
