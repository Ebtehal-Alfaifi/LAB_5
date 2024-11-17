package com.example.projecttrackersystem.TracckerController;


import com.example.projecttrackersystem.Api.ApiResponse;
import com.example.projecttrackersystem.Model.ProjectTrackerModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    ArrayList<ProjectTrackerModel> trackers=new ArrayList<>();

//display all project
    @GetMapping("/tracker")
    public ArrayList<ProjectTrackerModel> getTrackers() {
        return trackers;
    }


// add new project
@PostMapping("/add")
    public ApiResponse addTracker(@RequestBody ProjectTrackerModel tracker) {
        trackers.add(tracker);
        return new ApiResponse(" add success");
    }



@PutMapping("/update/{index}")
    public ApiResponse updateTracker(@PathVariable int index,@RequestBody ProjectTrackerModel tracker) {
        if (index>=0&&index<trackers.size()) {
trackers.set(index, tracker);
        return new ApiResponse(" update success");}

        return new ApiResponse(" update fail");
    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTracker(@PathVariable int index) {
        if (index >= 0 && index < trackers.size()) {
            trackers.remove(index);
            return new ApiResponse("Project deleted successfully");
        }
      return new ApiResponse(" delete failed");
    }



    @PutMapping("/status/{index}/{status}")
    public ApiResponse changeStatus(@PathVariable int index, @PathVariable String status) {
        if (index >= 0 && index < trackers.size()) {
            ProjectTrackerModel project = trackers.get(index);
            project.setStatus(status);
            return new ApiResponse("Project status updated to: " + status);
        }
        return new ApiResponse("Project status update failed: Index out of bounds");
    }




@GetMapping("/search/{title}")
    public  ArrayList <ProjectTrackerModel> searchProject(@PathVariable String title){
        for (ProjectTrackerModel tracker : trackers) {
            if (tracker.getTitle().equalsIgnoreCase(title)) {
               return trackers;

            }
        }

    return null;
}



    @GetMapping("/company/{companyName}")
    public ArrayList<ProjectTrackerModel> getProjectsByCompany(@PathVariable String companyName) {
        ArrayList<ProjectTrackerModel> trackers1=new ArrayList<>();
        for (ProjectTrackerModel project : trackers) {
            if (project.getCompanyName().equalsIgnoreCase(companyName)) {
                trackers1.add(project);
                return trackers1;
            }
        }
        return null;
    }
}



