package io.hcl.ppmtool.services;

import io.hcl.ppmtool.domain.Project;
import io.hcl.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        //Logic Here


        return projectRepository.save(project);
    }


}
