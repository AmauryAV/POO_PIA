package com.example.hospital_pia;

import enums.Triaje;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.*;

public class cola_prioridad {
    public PriorityQueue<registro_paciente> turnos;
    public static final Map<Triaje, Integer> tiempo_vida = new HashMap<>();
    static {
        tiempo_vida.put(Triaje.Rojo, 180000);
        tiempo_vida.put(Triaje.Naranja, 600000);
        tiempo_vida.put(Triaje.Amarillo, 1800000);
        tiempo_vida.put(Triaje.Verde, 7200000);
        tiempo_vida.put(Triaje.Azul, 10800000);
    }
    public cola_prioridad() {
        this.turnos = new PriorityQueue<>();
    }
//checar trabajo en multihilos para que funcione correctemente
    public void temporizador(registro_paciente registro, hospital hospital) {
        Triaje prioridad = registro.getTriaje();
        Integer tiempo = tiempo_vida.get(prioridad);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (turnos.contains(registro)) {
                    registro_defuncion registro_defuncion = new registro_defuncion(registro);
                    hospital.defuncions.put(registro_defuncion.id, registro_defuncion);
                    eliminarRegistro(registro);

                }
            }
        };timer.schedule(task, tiempo);

    }

    public void agregarRegistro(registro_paciente registro, hospital hospital) {
        turnos.add(registro);
        temporizador(registro, hospital);
    }

    public void eliminarRegistro(registro_paciente registro) {
        turnos.remove(registro);
    }

    public registro_paciente desencolarRegistro() {
        return turnos.poll();
    }
}
