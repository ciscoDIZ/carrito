/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciscodiz.carrito.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author tote
 */
public class manejarDB {

    private static EntityManagerFactory emf;

    private static EntityManager crearEntityManager() {
        if (emf == null || (emf != null & !emf.isOpen())) {
            emf = Persistence.createEntityManagerFactory("unidadPErsistencia");
        }
        return emf.createEntityManager();
    }

    public static List<Productos> obtenerProductos() {
        EntityManager em = crearEntityManager();
        List<Productos> lista = em.createNamedQuery(
                "Productos.findAll", Productos.class).getResultList();
        return lista;
    }

    public void insertarProducto(Productos p) {
        EntityManager em = crearEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.createNativeQuery(
                    "INSERT INTO PRODUCTOS (id, nombre, precio, cantidad) VALUES (?,?,?,?)")
                    .setParameter(1, p.getId())
                    .setParameter(2, p.getNombre())
                    .setParameter(3, p.getPrecio())
                    .setParameter(4, p.getCantidad())
                    .executeUpdate();
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }

    }

    public void insertarCliente(Clientes c) {
        EntityManager em = crearEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.createNativeQuery(
                    "INSERT INTO CLIENTES (id, nombre, apellido1, apellido2) VALUES (?,?,?,?)")
                    .setParameter(1, c.getId())
                    .setParameter(2, c.getNombre())
                    .setParameter(3, c.getApellido1())
                    .setParameter(4, c.getApellido2())
                    .executeUpdate();
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    public void insertarPedido(Pedidos p, Clientes c) {
        EntityManager em = crearEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.createNativeQuery(
                    "INSERT INTO PEDIDOS (id, fecha, idCliente) VALUES (?,?,?)")
                    .setParameter(1, p.getId())
                    .setParameter(2, p.getFecha())
                    .setParameter(3, c.getId())
                    .executeUpdate();
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }
}
