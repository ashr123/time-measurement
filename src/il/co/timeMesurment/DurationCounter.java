package il.co.timeMesurment;

import java.util.function.Supplier;

public class DurationCounter
{
	private static long timeTaken = Long.MIN_VALUE;

	private DurationCounter()
	{
	}

	public static double getTimeTaken(TimeScales timeScales)
	{
		if (timeTaken == Long.MIN_VALUE)
			throw new IllegalStateException("Didn't make execution yet!!");
		return timeTaken / timeScales.scale;
	}

	public static <T> T measureAndExecute(Supplier<T> supplier)
	{
		final long startTime = System.nanoTime();
		final T result = supplier.get();
		timeTaken = System.nanoTime() - startTime;
		return result;
	}
}
