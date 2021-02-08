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
		final long startTime = System.nanoTime();
		return new Result<>(supplier.get(), System.nanoTime() - startTime);
	}

	public static <T> Result<T> measureAndExecuteCallable(Callable<T> callable) throws Exception
	{
		final long startTime = System.nanoTime();
		return new Result<>(callable.call(), System.nanoTime() - startTime);
	}

	public static Result<Void> measureAndExecute(Runnable runnable)
	{
		final long startTime = System.nanoTime();
		runnable.run();
		return new Result<>(System.nanoTime() - startTime);
	}
}
