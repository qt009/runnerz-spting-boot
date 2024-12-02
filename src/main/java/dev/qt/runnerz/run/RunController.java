package dev.qt.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("api/run/update/{id}")
    public void updateRun(@PathVariable Integer id, @Valid @RequestBody Run run) {
        runRepository.updateRun(run, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("api/run/delete/{id}")
    public void deleteRun(@PathVariable Integer id) {
        runRepository.deleteRun(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/run")
    public void createRun(@Valid @RequestBody Run run){
        runRepository.createRun(run);
    }

    @GetMapping("/api/runs")
    List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping("api/runs/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }
}
