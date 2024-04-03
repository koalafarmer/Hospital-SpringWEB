package ma.dante.ioc3.web;

import lombok.AllArgsConstructor;
import ma.dante.ioc3.entities.Patient;
import ma.dante.ioc3.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue="0") int page,
                        @RequestParam(name="size",defaultValue = "4") int size,
                        @RequestParam(name="keyword",defaultValue ="")String kw
                        ){
        Page<Patient> pagePatient=patientRepository.findByNameContains(kw,PageRequest.of(page,size));
        model.addAttribute("ListPatients",pagePatient);
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
    return "patients";
    }

    @GetMapping("/patients/{id}/remove")
    public String showRemoveConfirmation(@PathVariable Long id, Model model) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        model.addAttribute("patient", patient);
        return "removePatient";
    }

    @PostMapping("/patients/{id}/remove")
    public String removePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
   @GetMapping("/delete")
    public String delete(Long id){
        patientRepository.deleteById(id);
        return "redirect:/index";
    }
}
