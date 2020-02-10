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

		DataStream<SensorReading> stream = env.addSource(new FlinkSource()).map(new MapFunction<SensorReading, SensorReading>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public SensorReading map(SensorReading reading) throws Exception {

				return reading;
			}
		}).setParallelism(1);
		stream.print();
		try {
			env.execute();
		} catch (Exception e) {
		}

	}

}
