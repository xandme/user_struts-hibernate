package com.qingshixun.project.model;

public class ChartData {
	private String names;
	private String values;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "ChartData [names=" + names + ", values=" + values + "]";
	}

}
