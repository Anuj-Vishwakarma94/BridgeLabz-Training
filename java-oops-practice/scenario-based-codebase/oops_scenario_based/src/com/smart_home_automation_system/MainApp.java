package com.smart_home_automation_system;
public class MainApp {

    public static void main(String[] args) {

        UserController controller = new UserController();

        Appliance light = new Light("Bedroom");
        Appliance fan = new Fan("Hall", 120, 3);
        Appliance ac = new AC("MasterRoom", 1800, 22);

        System.out.println("\n--- DEVICE STATUS ---");
        controller.showApplianceStatus(light);
        controller.showApplianceStatus(fan);
        controller.showApplianceStatus(ac);

        System.out.println("\n--- TURNING ON DEVICES ---");
        controller.turnOnDevice(light);
        controller.turnOnDevice(fan);
        controller.turnOnDevice(ac);

        System.out.println("\n--- UPDATED STATUS ---");
        controller.showApplianceStatus(light);
        controller.showApplianceStatus(fan);
        controller.showApplianceStatus(ac);

        System.out.println("\n--- ENERGY USAGE COMPARISON ---");
        light.compareUsage(fan);
        ac.compareUsage(light);

        System.out.println("\n--- TURNING OFF AC ---");
        controller.turnOffDevice(ac);
    }
}
