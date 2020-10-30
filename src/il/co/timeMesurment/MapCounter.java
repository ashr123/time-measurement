package il.co.timeMesurment;

import java.util.HashMap;
import java.util.Map;

public class MapCounter<T>
{
	private final Map<T, Long> startTimes = new HashMap<>();

	private MapCounter()
	{
	}

	public double getTimeTaken(T key, TimeScales timeScales)
	{
		Long value = startTimes.get(key);
		if (value == null)
			throw new IllegalStateException("Didn't start measuring yet!!");
		return value / timeScales.scale;
	}

	public void startMeasure(T key)
	{
		startTimes.put(key, System.nanoTime());
	}
}
