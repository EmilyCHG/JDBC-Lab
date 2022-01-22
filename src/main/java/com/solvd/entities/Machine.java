/**
 * 
 */
package com.solvd.entities;

public class Machine {

	private Integer IDmachine;
	private String machineName;
	private Integer IDemployee;
	private Integer IDsector;

	public Machine() {

	}

	public Machine(Integer iDmachine, String machineName) {
		super();
		this.IDmachine = iDmachine;
		this.machineName = machineName;
	}

	public Machine(Integer iDmachine, String machineName, Integer iDemployee,
			Integer iDsector) {
		super();
		IDmachine = iDmachine;
		this.machineName = machineName;
		IDemployee = iDemployee;
		IDsector = iDsector;
	}

	public Integer getIDmachine() {
		return IDmachine;
	}

	public void setIDmachine(Integer iDmachine) {
		this.IDmachine = iDmachine;
	}

	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public Integer getIDemployee() {
		return IDemployee;
	}

	public void setIDemployee(Integer iDemployee) {
		IDemployee = iDemployee;
	}

	public Integer getIDsector() {
		return IDsector;
	}

	public void setIDsector(Integer iDsector) {
		IDsector = iDsector;
	}

	@Override
	public String toString() {
		return "Machine [IDmachine=" + IDmachine + ", machineName="
				+ machineName + ", IDemployee=" + IDemployee + ", IDsector="
				+ IDsector + "]";
	}

}
