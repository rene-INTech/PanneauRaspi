package com.panneau;

import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import java.io.IOException;

public class RaspiExample {

    public static void main(String[] args) throws IOException, UnsupportedBusNumberException, TooManyDigitsException {

        Panneau panel=new Panneau(16, 65533,false);
        int i=Integer.parseInt(args[0]);
        System.out.println(i);
        panel.printScore(i);
        panel.addListener(newColor -> System.out.println(newColor));
        System.out.println(panel.getTeamColor());
        float f = 0f;
        int index = 0;
        while (true){
            try {
                panel.getLeds().set(LEDs.Color.NOIR);
                index++;
                index %= 16;
                f += 0.1f;
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }

    }
}
