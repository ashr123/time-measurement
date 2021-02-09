package il.co.timeMesurment;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class DurationCounter
{
	private DurationCounter()
	{
	}

	public static <T> Result<T> measureAndExecute(Supplier<T> supplier)
	{
		return new Result<>(System.nanoTime(), supplier.get(), System.nanoTime());
	}

	public static <T> Result<T> measureAndExecuteCallable(Callable<T> callable) throws Exception
	{
		return new Result<>(System.nanoTime(), callable.call(), System.nanoTime());
	}

	public static Result<Void> measureAndExecute(Runnable runnable)
	{
		final long startTime = System.nanoTime();
		runnable.run();
		return new Result<>(startTime, System.nanoTime());
	}
}
