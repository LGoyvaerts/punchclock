package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Job;
import ch.zli.m223.punchclock.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;

    public Job createCategory(Job job) {
        return jobRepository.saveAndFlush(job);
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }
}
