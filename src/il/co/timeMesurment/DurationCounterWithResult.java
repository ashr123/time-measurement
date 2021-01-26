package il.co.timeMesurment;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class DurationCounterWithResult
{
	private DurationCounterWithResult()
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

	public static Result<?> measureAndExecute(Runnable runnable)
	{
		final long startTime = System.nanoTime();
		runnable.run();
		return new Result<>(System.nanoTime() - startTime);
	}

	public static class Result<T>
	{
		private final T result;
		private final long timeTaken;

		private Result(long timeTaken)
		{
			this(null, timeTaken);
		}

		private Result(T result, long timeTaken)
		{
			this.result = result;
			this.timeTaken = timeTaken;
		}

		public T getResult()
		{
			return result;
		}

		public double getTimeTaken(TimeScales timeScales)
		{
			return timeTaken / timeScales.scale;
		}

		@Override
		public boolean equals(Object o)
		{
			if (this == o)
				return true;
			if (!(o instanceof Result))
				return false;
			Result<?> result1 = (Result<?>) o;
			return timeTaken == result1.timeTaken &&
			       Objects.equals(result, result1.result);
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(result, timeTaken);
		}

		@Override
		public String toString()
		{
			return "Result{" +
			       "result=" + result +
			       ", timeTaken=" + timeTaken + "nanoseconds" +
			       '}';
		}
	}
}
