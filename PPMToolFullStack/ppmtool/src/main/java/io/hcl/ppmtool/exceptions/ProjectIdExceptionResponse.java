package io.hcl.ppmtool.exceptions;

public class ProjectIdExceptionResponse {

    private String ProjectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.ProjectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return ProjectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        ProjectIdentifier = projectIdentifier;
    }
}
