package service;

import model.Nhanvien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.INhanvienRepository;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 10:12 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
@Service
public class NhanvienServiceImpl implements INhanvienService{
    @Autowired
    private INhanvienRepository iNhanvienRepository;
    @Override
    public List<Nhanvien> getlistNV() {
        return iNhanvienRepository.getlistNhanvien();
    }

    @Override
    public int save(Nhanvien nv) {
        return iNhanvienRepository.save(nv);
    }

    @Override
    public int update(Nhanvien nv) {
        return iNhanvienRepository.update(nv);
    }

    @Override
    public int delete(int id) {
        return iNhanvienRepository.delete(id);
    }

    @Override
    public Nhanvien getNhanvienbyID(int id) {
        return iNhanvienRepository.getNhanvienbyID(id);
    }
}
