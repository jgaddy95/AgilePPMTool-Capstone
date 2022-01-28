package io.hcl.ppmtool.ppmtool.services;

import io.hcl.ppmtool.ppmtool.domain.Backlog;
import io.hcl.ppmtool.ppmtool.domain.ProjectTask;
import io.hcl.ppmtool.ppmtool.repositories.BacklogRepository;
import io.hcl.ppmtool.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){


        //Pts to be added to a specific project, project !=null, BL exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        //set the backlog to the project task
        projectTask.setBacklog(backlog);

        // we want our project sequence to be like this: IDPRO-1 IDPRO-2 ...100 101
        Integer BacklogSequence = backlog.getPTSequence();
        //Update the backlog sequence
        BacklogSequence++;

        backlog.setPTSequence(BacklogSequence);

        //Add sequence to project task
        projectTask.setProjectSequence(backlog.getProjectIdentifier()+ "-" + BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        //INITIAL priority when priority null
        if(projectTask.getPriority()==null){
            projectTask.setPriority(3);
        }

        if(projectTask.getStatus()=="" || projectTask.getStatus()==null){
            projectTask.setStatus("TO_DO");
        }
        //initial is null
        return projectTaskRepository.save(projectTask);

    }

     public Iterable<ProjectTask>findBacklogById(String id){
        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }
}
