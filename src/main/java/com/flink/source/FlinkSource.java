/**
 * 
 */
package com.flink.source;

import java.util.Calendar;
import java.util.Random;

import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

import com.flink.pojo.SensorReading;

/**
 * @author anas
 *
 */
public class FlinkSource extends RichParallelSourceFunction<SensorReading> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// flag indicating whether source is still running
	private boolean running = true;
	static Random rand = new Random();

	@Override
	public void cancel() {
		running = false;
	}

	@Override
	public void run(SourceContext<SensorReading> srcCtx) throws Exception {

		
		int taskIndex = this.getRuntimeContext().getIndexOfThisSubtask();
		String sensorID = "sensor_" + taskIndex;
		double temperature;

		while (running) {
			long curTime = Calendar.getInstance().getTimeInMillis();
			temperature = rand.nextGaussian() * 0.5;
			srcCtx.collect(new SensorReading(sensorID, curTime, temperature));
		}

	}

}
