package com.lambdaexpression.smarthomelighting;

public class SmartLight {
    public static void main(String[] args) {

        LightAction motionTrigger = () ->
        System.out.println("Lights ON with bright white light");

        LightAction nightTimeTrigger = () ->
        System.out.println("Lights ON with dim warm light");

        LightAction voiceCommandTrigger = () ->
        System.out.println("Lights ON with party mode colors");

        motionTrigger.activate();
        nightTimeTrigger.activate();
        voiceCommandTrigger.activate();
    }
}