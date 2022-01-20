import React, { Component } from 'react';
import CreateProjectButton from './Project/CreateProjectButton';
import ProjectItem from './Project/ProjectItem';

class Dashboard  extends Component {
  render() {
    return (
        // <!-- Dashboard Component (Project Item included) -->

    <div className="projects">
    <div className="container">
        <div className="row">
            <div className="col-md-12">
                <h1 className="display-4 text-center">Projects</h1>
                <br />
                <CreateProjectButton />
                <br />
                <hr />
                <ProjectItem/>
            </div>
        </div>
    </div>
</div>

// <!-- End of Dashboard Component -->
    )
  }
}


export default Dashboard;