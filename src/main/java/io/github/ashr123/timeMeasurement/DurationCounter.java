package io.github.ashr123.timeMeasurement;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class DurationCounter
{
	private DurationCounter()
	{
	}

	public static <T> Result<T> measureAndExecute(final Supplier<T> supplier)
	{
		return new Result<>(System.nanoTime(), supplier.get(), System.nanoTime());
	}

	public static <T> Result<T> measureAndExecuteCallable(final Callable<T> callable) throws Exception
	{
		return new Result<>(System.nanoTime(), callable.call(), System.nanoTime());
	}

	public static Result<Void> measureAndExecute(final Runnable runnable)
	{
		final long startTime = System.nanoTime();
		runnable.run();
		final long endTime = System.nanoTime();
		return new Result<>(startTime, endTime);
	}
}