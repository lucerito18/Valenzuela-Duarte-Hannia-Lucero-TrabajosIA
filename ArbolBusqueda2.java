package IA;

import java.util.*;

public class ArbolBusqueda2 {
    Nodo2 raiz;
    String estadoObjetivo;

    public ArbolBusqueda2(Nodo2 raiz, String estadoObjetivo) {
        this.raiz = raiz;
        this.estadoObjetivo = estadoObjetivo;
    }

    public Nodo2 busquedaPrimeroAnchura() {
        if (raiz == null) return null;

        HashSet<String> visitados = new HashSet<>();
        Queue<Nodo2> cola = new LinkedList<>();

        cola.add(raiz);
        visitados.add(raiz.estado);

        while (!cola.isEmpty()) {
            Nodo2 actual = cola.poll();

            // Verificar si llegamos a la meta
            if (actual.estado.equals(estadoObjetivo)) {
                return actual;
            }

            // Obtener los sucesores usando la lógica de los índices
            List<String> sucesores = Nodo2.getSucesores(actual.estado);

            for (String st : sucesores) {
                if (!visitados.contains(st)) {
                    visitados.add(st);
                    cola.add(new Nodo2(st, actual));
                }
            }
        }
        return null;
    }
}