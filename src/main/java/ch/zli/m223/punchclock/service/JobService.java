package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Job;
import ch.zli.m223.punchclock.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;

    // Constructor for Injection
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.saveAndFlush(job);
    }

    public void deleteJobById(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }
}
