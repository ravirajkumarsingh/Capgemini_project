package com.cpg.sprint1.services;

import java.util.List;

import com.cpg.sprint1.entities.Diagnostic_center;

public interface IDiagnostic_centerService {
	public String addCenter(Diagnostic_center dc);
	public boolean removeCenter(String centerId);
	public List<Diagnostic_center> centerList(Diagnostic_center dc);

}