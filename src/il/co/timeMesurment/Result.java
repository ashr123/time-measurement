package il.co.timeMesurment;

import java.util.Objects;

public class Result<T>
{
	private final T result;
	private final long timeTaken;
	private final boolean isContainsResult;

	Result(long startTime, long endTime)
	{
		this(startTime, null, endTime, false);
	}

	Result(long startTime, T result, long endTime)
	{
		this(startTime, result, endTime, true);
	}

	private Result(long startTime, T result, long endTime, boolean isContainsResult)
	{
		this.result = result;
		this.timeTaken = endTime - startTime;
		this.isContainsResult = isContainsResult;
	}

	public T getResult()
	{
		if (isContainsResult)
			return result;
		throw new IllegalStateException("Doesn't have a result!");
	}

	public double getTimeTaken()
	{
		return getTimeTaken(TimeScales.MILLISECONDS);
	}

	public double getTimeTaken(TimeScales timeScales)
	{
		return timeTaken / timeScales.getScale();
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
		       isContainsResult == result1.isContainsResult &&
		       Objects.equals(result, result1.result);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(result, timeTaken, isContainsResult);
	}

	@Override
	public String toString()
	{
		return "Result{" +
		       "result=" + result +
		       ", timeTaken=" + timeTaken +
		       ", isContainsResult=" + isContainsResult +
		       '}';
	}
}
