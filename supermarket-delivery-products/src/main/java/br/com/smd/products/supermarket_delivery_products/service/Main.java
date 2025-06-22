package br.com.smd.products.supermarket_delivery_products.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHour = scanner.nextInt();
        int initialMinute = scanner.nextInt();
        int finalHour = scanner.nextInt();
        int finalMinute = scanner.nextInt();

        LocalTime startTime = LocalTime.of(initialHour, initialMinute);
        LocalTime endTime = LocalTime.of(finalHour, finalMinute);

        Duration duration;
        if (endTime.isBefore(startTime) || endTime.equals(startTime)) {
            duration = Duration.between(startTime, endTime.plus(Duration.ofDays(1)));

        } else {
            duration = Duration.between(startTime, endTime);
        }

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        if (hours == 0 && minutes == 0) {
            hours = 24;
        }

        System.out.println(String.format("O JOGO DUROU %d HORA(S) E %d MINUTO(S)", hours, minutes));
    }

}
