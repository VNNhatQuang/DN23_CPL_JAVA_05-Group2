package api;

import com.DiamondCafe.DiamondCafe.model.Nhanvien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DiamondCafe.DiamondCafe.service.INhanvienService;

import java.util.List;

/**
 * @CREATED 04/05/2023 - 1:58 PM
 * @PROJECT Project
 * @AUTHOR Kiel
 */

@RestController
@RequestMapping("/api/nhanvien")
public class NhanvienAPI {
    @Autowired
    private INhanvienService iNhanvienService;

    @GetMapping("/")
    public ResponseEntity<List<Nhanvien>> getlistNhanvien(){
        var result = iNhanvienService.getlistNV();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
