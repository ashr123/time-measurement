//package io.github.ashr123.timeMeasurement;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class MapCounter<T>
//{
//	private final Map<T, Long> startTimes = new HashMap<>();
//
//	private MapCounter()
//	{
//	}
//
//	public double getTimeTaken(T key)
//	{
//		return getTimeTaken(key, TimeScales.MILLISECONDS);
//	}
//
//	public double getTimeTaken(T key, TimeScales timeScales)
//	{
//		final Long value = startTimes.get(key);
//		if (value == null)
//			throw new IllegalStateException("Didn't start measuring yet!!");
//		return (System.nanoTime() - value) / timeScales.getScale();
//	}
//
//	public void startMeasure(T key)
//	{
//		startTimes.put(key, System.nanoTime());
//	}
//}