package com.bamboo.jdk.pojo;

/**
 * @Description TODO
 * @Author victor su
 * @Date 2019/8/6 11:47
 **/
public class Device {

    private Integer deviceId;

    private String deviceType;

    public Device(Integer deviceId, String deviceType){
        this.deviceId = deviceId;
        this.deviceType = deviceType;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceType='" + deviceType + '\'' +
                '}';
    }
}
