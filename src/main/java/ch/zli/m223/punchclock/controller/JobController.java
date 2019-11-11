package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Job;
import ch.zli.m223.punchclock.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    // Constructor for Injection
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    // Create Category
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Job> getAllEntries() {
        return jobService.findAll();
    }

    // Create Job
    public Job createJob(@Valid @RequestBody Job job) {
        return jobService.createJob(job);
    }
}
