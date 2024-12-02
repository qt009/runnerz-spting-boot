package dev.qt.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }
    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id().equals(id)).findFirst();
    }

    public void createRun(Run run){
        runs.add(run);
    }

    public void updateRun (Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        existingRun.ifPresent(value -> runs.set(runs.indexOf(value), run));
    }

    public void deleteRun (Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "First", LocalDateTime.now(),
                LocalDateTime.now().plusHours(4), 3, Location.Indoor));

        runs.add(new Run(2, "Second", LocalDateTime.now().plusHours(4),
                LocalDateTime.now().plusDays(1), 4, Location.Indoor));
    }
}
