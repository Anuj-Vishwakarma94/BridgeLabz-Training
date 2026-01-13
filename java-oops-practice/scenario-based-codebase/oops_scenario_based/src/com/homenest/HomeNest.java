package com.homenest;

import java.util.Scanner;

public class HomeNest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== HomeNest Smart Home =====");

        Light livingRoomLight = new Light("LIV-LT-01");
        Camera frontDoorCam = new Camera("ENT-CAM-02");
        Thermostat bedroomAC = new Thermostat("BED-AC-03");
        Lock mainDoorLock = new Lock("MAIN-LOCK-04");

        IControllable[] devices = {
                livingRoomLight,
                frontDoorCam,
                bedroomAC,
                mainDoorLock
        };

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Turn ON all devices");
            System.out.println("2. Set Light Brightness");
            System.out.println("3. Start Camera Recording");
            System.out.println("4. Set AC Temperature");
            System.out.println("5. Show Device Status");
            System.out.println("6. Show Energy Usage (Light + AC)");
            System.out.println("7. Reset All Devices");
            System.out.println("8. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (IControllable dev : devices) {
                        dev.turnOn();
                    }
                    break;

                case 2:
                    System.out.print("Enter brightness (0–100): ");
                    int brightness = sc.nextInt();
                    livingRoomLight.setBrightness(brightness);
                    break;

                case 3:
                    frontDoorCam.startRecording();
                    break;

                case 4:
                    System.out.print("Enter temperature: ");
                    double temp = sc.nextDouble();
                    bedroomAC.setTemperature(temp);
                    break;

                case 5:
                    System.out.println("\n--- Device Status ---");
                    for (SmartDevice dev : new SmartDevice[]{
                            livingRoomLight, frontDoorCam, bedroomAC, mainDoorLock
                    }) {
                        System.out.println(dev);
                    }
                    break;

                case 6:
                    System.out.println("Total energy used (Light + AC): "
                            + String.format("%.2f kWh",
                            livingRoomLight.plusEnergy(bedroomAC)));
                    break;

                case 7:
                    for (IControllable dev : devices) {
                        dev.reset();
                    }
                    break;

                case 8:
                    System.out.println("Exiting HomeNest. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
