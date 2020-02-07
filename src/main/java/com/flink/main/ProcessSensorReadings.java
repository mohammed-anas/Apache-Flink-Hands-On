/**
 * 
 */
package com.flink.main;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import com.flink.pojo.SensorReading;
import com.flink.source.FlinkSource;

/**
 * @author anas
 *
 */
public class ProcessSensorReadings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		DataStream<Long> stream = env.addSource(new FlinkSource())
									.map(new MapFunction<SensorReading, Long>() {

										/**
										 * 
										 */
										private static final long serialVersionUID = 1L;

										@Override
										public Long map(SensorReading reading) throws Exception {
											
											return reading.timestamp;
										}
									}).setParallelism(1);
		stream.print();
		try {
			env.execute();
		} catch (Exception e) {
		}
		
	}

}
