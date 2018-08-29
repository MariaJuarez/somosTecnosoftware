package ar.com.tecnosoftware.somos.liderServicio.repository.impl;

import ar.com.tecnosoftware.somos.liderServicio.entity.LiderServicio;
import ar.com.tecnosoftware.somos.liderServicio.repository.LiderServicioRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LiderServicioRepositoryImpl implements LiderServicioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(LiderServicio liderServicio) {
        entityManager.persist(liderServicio);
    }

    @Override
    public LiderServicio buscar(int id) {
        return entityManager.find(LiderServicio.class,id);
    }

    @Override
    public List buscar(String extension) {
        String hql = "FROM LiderServicio " + extension;
        return (List<LiderServicio>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public LiderServicio darBaja(LiderServicio liderServicio) {
        liderServicio.setBaja(true);
        return entityManager.merge(liderServicio);
    }

    @Override
    public LiderServicio editar(LiderServicio liderServicio) {
        return entityManager.merge(liderServicio);
    }
}
