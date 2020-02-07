/**
 * 
 */
package com.flink.pojo;

/**
 * @author anas
 *
 */
/**
 * 
 * POJO to hold employee record
 *
 */
public class SensorReading {
	
	public String id;
	public long timestamp;
	public double temperature;
	
	public SensorReading() {
	}

	public SensorReading(String id, long timestamp, double temperature) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "SensorReading [id=" + id + ", timestamp=" + timestamp + ", temperature=" + temperature + "]";
	}
	
	
	
	
	
	

}
