package com.example.demo.provided;

import java.util.List;

import com.example.demo.bean.Conseils;
import com.example.demo.bean.Intervention;
import com.example.demo.service.ConseilsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("GMAO/Conseils-api")
public class ConseilsProvided {
    @Autowired
    private ConseilsService conseilsService;

    @GetMapping("CodeCollaborateur/{code}")
    public List<Conseils> findByCollaborateurCodeCollaborateur(@PathVariable String code) {
        return conseilsService.findByCollaborateurCodeCollaborateur(code);
    }

    /*
     * @GetMapping("EquipRef/{ref}") public List<Consigne>
     * findByEquipeRef(@PathVariable String ref) { return
     * conseilsService.findByEquipeRef(ref); }
     */
    // @GetMapping("date/{date}")
    // public List<Conseils> findByDateDeMessage(Date date) {
    // return conseilsService.findByDateDeMessage(date);
    // }
    // @GetMapping("EquipRef/{ref}/CodeCollaborateur/{code}")
    // public List<Consigne>
    // findByEquipeRefAndCollaborateurcodeCollaborateur(@PathVariable String ref,
    // @PathVariable String code) {
    // return conseilsService.findByEquipeRefAndCollaborateurcodeCollaborateur(ref,
    // code);
    // }
    @GetMapping("intervention/{code}")
    public List<Conseils> findByInterventionCode(@PathVariable String code) {
        return conseilsService.findByInterventionCode(code);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        conseilsService.deleteById(id);
    }

    // @DeleteMapping("date/{date}")
    // public int deleteByDateDeMessage(@PathVariable Date date) {
    // return conseilsService.deleteByDateDeMessage(date);
    // }

    @DeleteMapping("code/{code}/message/{message}/interv/{interv}")
    public int deleteByCollaborateurCodeCollaborateurAndInterventionCode(@PathVariable String code,
            @PathVariable String message, @PathVariable String interv) {
        return conseilsService.deleteByCollaborateurCodeCollaborateur(code, message, interv);
    }

    @GetMapping("/")
    public List<Conseils> findAll() {
        return conseilsService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Intervention intervention, @RequestBody Conseils conseils) {
        return conseilsService.save(intervention, conseils);
    }
}
