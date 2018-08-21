package ar.com.tecnosoftware.somos.service.impl;

import ar.com.tecnosoftware.somos.entity.Cargo;
import ar.com.tecnosoftware.somos.repository.CargoRepository;
import ar.com.tecnosoftware.somos.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    /**
     * Metodo para añadir cargo a la DB
     *
     */

    @Override
    public void add(Cargo cargo) {
        cargoRepository.guardar(cargo);
    }

    @Override
    public Cargo buscar(int id) {
        return cargoRepository.buscar(id);
    }

    @Override
    public List<Cargo> buscarTodos() {
        return cargoRepository.buscarTodos();
    }

    @Override
    public void darBaja(int id) {
        cargoRepository.darBaja(cargoRepository.buscar(id));
    }
}
