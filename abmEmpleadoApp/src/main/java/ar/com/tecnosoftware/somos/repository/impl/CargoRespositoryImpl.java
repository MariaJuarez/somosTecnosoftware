package ar.com.tecnosoftware.somos.repository.impl;

import ar.com.tecnosoftware.somos.entity.Cargo;
import ar.com.tecnosoftware.somos.repository.CargoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CargoRespositoryImpl implements CargoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Object entity) {
        entityManager.persist(entity);
    }

    @Override
    public Cargo buscar(int id) {
        return entityManager.find(Cargo.class, id);
    }

    @Override
    public List<Cargo> buscarTodos() {
        String hql = "FROM Cargo WHERE baja = false";
        return (List<Cargo>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void darBaja(Object entity) {
        Cargo cargo = (Cargo) entity;
        cargo.setBaja(true);
        entityManager.flush();
    }
}