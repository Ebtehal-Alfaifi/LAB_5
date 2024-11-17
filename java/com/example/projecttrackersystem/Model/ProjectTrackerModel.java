package com.example.projecttrackersystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectTrackerModel {
    private String id;
    private String title;
    private String description;
    private String status;
    private String companyName;
}
