package repository;

import model.Nhanvien;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 9:46 AM
 * @PROJECT Project
 * @AUTHOR Kiel
 */
public interface INhanvienRepository {
    public List<Nhanvien> getlistNhanvien();
    public int save(Nhanvien nv);
    public int update(Nhanvien nv);
    public int delete(int id);
    public Nhanvien getNhanvienbyID(int id);

}
