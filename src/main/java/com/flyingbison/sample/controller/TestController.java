package com.flyingbison.sample.controller;

import com.flyingbison.sample.domain.SampleDomain;
import com.flyingbison.sample.repository.SampleDomainRepository;
import org.springframework.web.bind.annotation.*;

/**
 * @author FlyingBison
 */
@RestController
@RequestMapping("/Test")
public class TestController {

    private SampleDomainRepository sampleDomainRepository;

    TestController(SampleDomainRepository sampleDomainRepository){
        this.sampleDomainRepository = sampleDomainRepository;
    }

    @PostMapping
    SampleDomain createSampleDomain(@RequestBody SampleDomain sampleDomain){
        return sampleDomainRepository.save(sampleDomain);
    }

    @GetMapping("/{sampleId}")
    SampleDomain getSampleDomain(@PathVariable("sampleId") long sampleId){
            return sampleDomainRepository.findById(sampleId).orElse(null);
    }
}
