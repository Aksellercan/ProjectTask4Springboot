package com.example.ProjectTask4;

//Data transfer object for smartphone
//Mainly used for  displaying smartphones
public class SmartphoneDTO {
        private long id;
        private String name;
        private int ram;
        private double processorspeed;
        private int batterysize;
        private double screensize;
        private int storage;
        private String operatingSystemName;

        // Constructor
        public SmartphoneDTO(Smartphone smartphone) {
            this.id = smartphone.getId();
            this.name = smartphone.getName();
            this.ram = smartphone.getRam();
            this.processorspeed = smartphone.getProcessorspeed();
            this.batterysize = smartphone.getBatterysize();
            this.screensize = smartphone.getScreensize();
            this.storage = smartphone.getStorage();
            this.operatingSystemName = smartphone.getOperatingSystem().getName();
        }

        // Getters and setters (optional if using public fields)
        public void setId(long id) {
            this.id = id;
        }
        public long getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getRam() {
            return ram;
        }
        public void setRam(int ram) {
            this.ram = ram;
        }
        public double getProcessorspeed() {
            return processorspeed;
        }
        public void setProcessorspeed(double processorspeed) {
            this.processorspeed = processorspeed;
        }
        public int getBatterysize() {
            return batterysize;
        }
        public void setBatterysize(int batterysize) {
            this.batterysize = batterysize;
        }
        public double getScreensize() {
            return screensize;
        }
        public void setScreensize(double screensize) {
            this.screensize = screensize;
        }
        public int getStorage() {
            return storage;
        }
        public void setStorage(int storage) {
            this.storage = storage;
        }
        public String getOperatingSystemName() {
            return operatingSystemName;
        }
        public void setOperatingSystemName(String operatingSystemName) {
            this.operatingSystemName = operatingSystemName;
        }
    }

