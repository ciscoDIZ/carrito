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

    public static List<Pedidos> obtenerPedidos() {
        EntityManager em = crearEntityManager();
        List<Pedidos> lista = em.createNamedQuery(
                "Pedidos.findAll", Pedidos.class).getResultList();
        return lista;
    }

    public static List<Clientes> obtenerClientes() {
        EntityManager em = crearEntityManager();
        List<Clientes> lista = em.createNamedQuery(
                "Clientes.findAll", Clientes.class).getResultList();
        return lista;
    }

    public static List<DetallePedidos> obtenerDetallesPedidos() {
        EntityManager em = crearEntityManager();
        List<DetallePedidos> lista = em.createNamedQuery(
                "DetallesPedidos.findAll", DetallePedidos.class).getResultList();
        return lista;
    }
    
    public void insertarProducto(Productos p) {
        EntityManager em = crearEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(p);
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
            em.persist(c);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    public void insertarPedido(Pedidos p) {
        EntityManager em = crearEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(p);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    public void insertarDetallesPedido(DetallePedidos dp) {
        EntityManager em = crearEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(dp);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }
}
